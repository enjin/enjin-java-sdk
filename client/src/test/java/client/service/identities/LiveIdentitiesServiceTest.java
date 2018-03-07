package client.service.identities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.identities.AsynchronousIdentitiesService;
import io.enjincoin.sdk.client.service.identities.SynchronousIdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.Identity;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Calls out to the actual api
 * Will have the disabled annotation in place usually but will be useful for testing the actual api
 *
 */
public class LiveIdentitiesServiceTest extends BaseLiveServiceTest {


    @Test
    public void testSynchronousIdentitiesService_GetIdentities() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Response<Identity[]> getIdentityResponseVOArray = identitiesService.getIdentitiesSync();
        assertThat(getIdentityResponseVOArray).isNotNull();
        assertThat(getIdentityResponseVOArray.body()).isNotNull();

        for (Identity getIdentityResponseVO : getIdentityResponseVOArray.body()) {
            if (getIdentityResponseVO.getFields() != null) {

                for (IdentityField fieldVO : getIdentityResponseVO.getFields()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentities() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        //CompletableFuture<Identity[]> getIdentityResponseVOArrayCf =
        identitiesService.getIdentitiesAsync(new Callback<Identity[]>() {

            @Override
            public void onResponse(Call<Identity[]> call, Response<Identity[]> getIdentityResponseVOArrayR) {
                assertThat(getIdentityResponseVOArrayR).isNotNull();
                assertThat(getIdentityResponseVOArrayR.body()).isNotNull();
                Identity[] getIdentityResponseVOArray = getIdentityResponseVOArrayR.body();

                for (Identity getIdentityResponseVO : getIdentityResponseVOArray) {
                    if (getIdentityResponseVO.getFields() != null) {

                        for (IdentityField fieldVO : getIdentityResponseVO.getFields()) {
                            assertThat(fieldVO).isNotNull();
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<Identity[]> call, Throwable t) {
                    fail("Test Failed");
            }
        });

    }

    @Test
    public void testSynchronousIdentitiesService_GetIdentitiesWithFilter() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        List<String> keyList =  new LinkedList<String>();
        keyList.add("player_name");
        List<String> fieldValueList =  new LinkedList<String>();
        fieldValueList.add("Player One");

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("key", keyList);
        filterMap.put("field_value", fieldValueList);

        Response<Identity[]> getIdentityResponseVOArray = identitiesService.getIdentitiesSync(filterMap);
        assertThat(getIdentityResponseVOArray).isNotNull();
        assertThat(getIdentityResponseVOArray.body()).isNotNull();

        for (Identity getIdentityResponseVO : getIdentityResponseVOArray.body()) {
            if (getIdentityResponseVO.getFields() != null) {

                for (IdentityField fieldVO : getIdentityResponseVO.getFields()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentitiesWithFilter() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        List<String> keyList =  new LinkedList<String>();
        keyList.add("player_name");
        List<String> fieldValueList =  new LinkedList<String>();
        fieldValueList.add("Player One");

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("key", keyList);
        filterMap.put("field_value", fieldValueList);

        //CompletableFuture<Identity[]> getIdentityResponseVOArrayCf = identitiesService.getIdentitiesAsync(filterMap);
        identitiesService.getIdentitiesAsync(filterMap, new Callback<Identity[]>() {

            @Override
            public void onResponse(Call<Identity[]> call, Response<Identity[]> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();
                Identity[] getIdentityResponseVOArray = response.body();

                for (Identity getIdentityResponseVO : getIdentityResponseVOArray) {
                    if (getIdentityResponseVO.getFields() != null) {

                        for (IdentityField fieldVO : getIdentityResponseVO.getFields()) {
                            assertThat(fieldVO).isNotNull();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Identity[]> call, Throwable t) {
                fail("Test Failed");
            }
        });

    }

    @Test
    public void testSynchronousIdentitiesService_GetIdentityById() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestBody = new CreateIdentityRequestBody(1, ethereumAddress, null);
        Response<CreateIdentityResponseBody> createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestBody);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.body()).isNotNull();
        assertThat(createIdentityResponseVO.body().getId()).isNotNull();
        assertThat(createIdentityResponseVO.body().getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.body().getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.body().getId();

        Response<Identity> getIdentityByIdResponseVO = identitiesService.getIdentitySync(identityId);
        assertThat(getIdentityByIdResponseVO).isNotNull();
        assertThat(getIdentityByIdResponseVO.body()).isNotNull();

        if (getIdentityByIdResponseVO.body().getFields() != null) {

            for (IdentityField fieldVO : getIdentityByIdResponseVO.body().getFields()) {
                assertThat(fieldVO).isNotNull();
            }
        }

        Response<Boolean> deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isNotNull();
        assertThat(deleteIdentityResult.body()).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentityById() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestVO = new CreateIdentityRequestBody(1, ethereumAddress, null);
        identitiesService.createIdentityAsync(createIdentityRequestVO, new Callback<CreateIdentityResponseBody>() {

            @Override
            public void onResponse(Call<CreateIdentityResponseBody> call, Response<CreateIdentityResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateIdentityResponseBody createIdentityResponseVO = response.body();
                assertThat(createIdentityResponseVO.getId()).isNotNull();
                assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
                assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

                Integer identityId = createIdentityResponseVO.getId();

                identitiesService.getIdentityAsync(identityId, new Callback<Identity>() {

                    @Override
                    public void onResponse(Call<Identity> call, Response<Identity> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();

                        Identity getIdentityByIdResponseVO = response.body();
                        if (getIdentityByIdResponseVO.getFields() != null) {

                            for (IdentityField fieldVO : getIdentityByIdResponseVO.getFields()) {
                                assertThat(fieldVO).isNotNull();
                            }
                        }

                        identitiesService.deleteIdentityAsync(identityId, new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                assertThat(response).isNotNull();
                                assertThat(response.body()).isNotNull();
                                assertThat(response.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Identity> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

            }

            @Override
            public void onFailure(Call<CreateIdentityResponseBody> call, Throwable t) {
                fail("Test failed");
            }
        });

    }

    @Test
    public void testSynchronousIdentitiesService_CreateIdentity() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestBody = new CreateIdentityRequestBody(1, ethereumAddress, null);

        Response<CreateIdentityResponseBody> createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestBody);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.body()).isNotNull();
        assertThat(createIdentityResponseVO.body().getId()).isNotNull();
        assertThat(createIdentityResponseVO.body().getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.body().getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.body().getId();

        Response<Identity> getIdentityByIdResponseVO = identitiesService.getIdentitySync(identityId);
        assertThat(getIdentityByIdResponseVO).isNotNull();
        assertThat(getIdentityByIdResponseVO.body()).isNotNull();

        if (getIdentityByIdResponseVO.body().getFields() != null) {

            for (IdentityField fieldVO : getIdentityByIdResponseVO.body().getFields()) {
                assertThat(fieldVO).isNotNull();
            }
        }

        Response<Boolean> deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isNotNull();
        assertThat(deleteIdentityResult.body()).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_CreateIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestVO = new CreateIdentityRequestBody(1, ethereumAddress, null);
        identitiesService.createIdentityAsync(createIdentityRequestVO, new Callback<CreateIdentityResponseBody>() {

            @Override
            public void onResponse(Call<CreateIdentityResponseBody> call, Response<CreateIdentityResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateIdentityResponseBody createIdentityResponseVO = response.body();
                assertThat(createIdentityResponseVO.getId()).isNotNull();
                assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
                assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

                Integer identityId = createIdentityResponseVO.getId();

                identitiesService.getIdentityAsync(identityId, new Callback<Identity>() {

                    @Override
                    public void onResponse(Call<Identity> call, Response<Identity> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();

                        Identity getIdentityByIdResponseVO = response.body();
                        if (getIdentityByIdResponseVO.getFields() != null) {

                            for (IdentityField fieldVO : getIdentityByIdResponseVO.getFields()) {
                                assertThat(fieldVO).isNotNull();
                            }
                        }

                        identitiesService.deleteIdentityAsync(identityId, new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                assertThat(response).isNotNull();
                                assertThat(response.body()).isNotNull();
                                assertThat(response.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Identity> call, Throwable t) {
                        fail("Test Failed");
                    }
                });

            }

            @Override
            public void onFailure(Call<CreateIdentityResponseBody> call, Throwable t) {
                fail("Test Failed");
            }
        });

    }

    @Test
    public void testSynchronousIdentitiesService_DeleteIdentity() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestBody = new CreateIdentityRequestBody(1, ethereumAddress, null);
        Response<CreateIdentityResponseBody> createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestBody);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.body()).isNotNull();
        assertThat(createIdentityResponseVO.body().getId()).isNotNull();
        assertThat(createIdentityResponseVO.body().getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.body().getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.body().getId();

        Response<Boolean> deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isNotNull();
        assertThat(deleteIdentityResult.body()).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_DeleteIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestVO = new CreateIdentityRequestBody(1, ethereumAddress, null);
        identitiesService.createIdentityAsync(createIdentityRequestVO, new Callback<CreateIdentityResponseBody>( ) {

            @Override
            public void onResponse(Call<CreateIdentityResponseBody> call, Response<CreateIdentityResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateIdentityResponseBody createIdentityResponseVO = response.body();
                assertThat(createIdentityResponseVO.getId()).isNotNull();
                assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
                assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

                Integer identityId = createIdentityResponseVO.getId();

                identitiesService.deleteIdentityAsync(identityId, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();
                        assertThat(response.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }
                });
            }

            @Override
            public void onFailure(Call<CreateIdentityResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }

    @Test
    public void testSynchronousIdentitiesService_UpdateIdentity() throws IOException {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestBody = new CreateIdentityRequestBody(1, ethereumAddress, null);
        Response<CreateIdentityResponseBody> createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestBody);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.body()).isNotNull();
        assertThat(createIdentityResponseVO.body().getId()).isNotNull();
        assertThat(createIdentityResponseVO.body().getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.body().getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.body().getId();

        IdentityField field1 = new IdentityField("player_name", "Player Ten", 1, 1, 1);
        IdentityField field2 = new IdentityField("New Field", "New Field Data", 1, 1, 1);
        IdentityField[] fieldsArray = new IdentityField[] {field1, field2};
        IdentityField[] fields = fieldsArray;

        UpdateIdentityRequestBody updateIdentityRequestBody = new UpdateIdentityRequestBody(fields);
        Response<UpdateIdentityResponseBody> updateIdentityResponseVO = identitiesService.updateIdentitySync(identityId, updateIdentityRequestBody);
        assertThat(updateIdentityResponseVO).isNotNull();
        assertThat(updateIdentityResponseVO.body()).isNotNull();
        assertThat(updateIdentityResponseVO.body().getId()).isNotNull();
        assertThat(updateIdentityResponseVO.body().getEthereumAddress()).isNotNull();
        assertThat(updateIdentityResponseVO.body().getCreatedAt()).isNotNull();
        assertThat(updateIdentityResponseVO.body().getUpdatedAt()).isNotNull();
        //assertThat(updateIdentityResponseVO.getUserId()).isNotNull();
        assertThat(updateIdentityResponseVO.body().getLinkingCode()).isNotNull();

        Response<Boolean> deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isNotNull();
        assertThat(deleteIdentityResult.body()).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_UpdateIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();
        CreateIdentityRequestBody createIdentityRequestVO = new CreateIdentityRequestBody(1, ethereumAddress, null);
        identitiesService.createIdentityAsync(createIdentityRequestVO, new Callback<CreateIdentityResponseBody>() {

            @Override
            public void onResponse(Call<CreateIdentityResponseBody> call, Response<CreateIdentityResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                CreateIdentityResponseBody createIdentityResponseVO = response.body();
                assertThat(createIdentityResponseVO.getId()).isNotNull();
                assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
                assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

                Integer identityId = createIdentityResponseVO.getId();

                IdentityField field1 = new IdentityField("player_name", "Player Ten", 1, 1, 1);
                IdentityField field2 = new IdentityField("New Field", "New Field Data", 1, 1, 1);
                IdentityField[] fieldsArray = new IdentityField[] {field1, field2};
                IdentityField[] fields = fieldsArray;

                UpdateIdentityRequestBody updateIdentityRequestVO = new UpdateIdentityRequestBody(fields);
                identitiesService.updateIdentityAsync(identityId, updateIdentityRequestVO, new Callback<UpdateIdentityResponseBody>() {

                    @Override
                    public void onResponse(Call<UpdateIdentityResponseBody> call, Response<UpdateIdentityResponseBody> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();

                        UpdateIdentityResponseBody updateIdentityResponseVO = response.body();
                        assertThat(updateIdentityResponseVO.getId()).isNotNull();
                        assertThat(updateIdentityResponseVO.getEthereumAddress()).isNotNull();
                        assertThat(updateIdentityResponseVO.getCreatedAt()).isNotNull();
                        assertThat(updateIdentityResponseVO.getUpdatedAt()).isNotNull();
                        //assertThat(updateIdentityResponseVO.getUserId()).isNotNull();
                        assertThat(updateIdentityResponseVO.getLinkingCode()).isNotNull();

                        identitiesService.deleteIdentityAsync(identityId, new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                assertThat(response).isNotNull();
                                assertThat(response.body()).isNotNull();
                                assertThat(response.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<UpdateIdentityResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }
                });

            }

            @Override
            public void onFailure(Call<CreateIdentityResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }
}
