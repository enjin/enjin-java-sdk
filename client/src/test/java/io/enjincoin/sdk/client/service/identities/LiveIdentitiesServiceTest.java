package io.enjincoin.sdk.client.service.identities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.CreateIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.FieldVO;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityRequestVO;
import io.enjincoin.sdk.client.vo.identity.UpdateIdentityResponseVO;

/**
 * Calls out to the actual api
 * Will have the disabled annotation in place usually but will be useful for testing the actual api
 *
 */
public class LiveIdentitiesServiceTest extends BaseLiveServiceTest{


    @Test
    public void testSychronousIdentitiesService_GetIdentities() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        GetIdentityResponseVO[] getIdentityResponseVOArray = identitiesService.getIdentitiesSync();
        assertThat(getIdentityResponseVOArray).isNotNull();

        for (GetIdentityResponseVO getIdentityResponseVO : getIdentityResponseVOArray) {
            if (getIdentityResponseVO.getFields().isPresent()) {

                for (FieldVO fieldVO : getIdentityResponseVO.getFields().get()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentities() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        CompletableFuture<GetIdentityResponseVO[]> getIdentityResponseVOArrayCf = identitiesService.getIdentitiesAsync();
        assertThat(getIdentityResponseVOArrayCf).isNotNull();
        assertThat(getIdentityResponseVOArrayCf.get()).isNotNull();
        GetIdentityResponseVO[] getIdentityResponseVOArray = getIdentityResponseVOArrayCf.get();

        for (GetIdentityResponseVO getIdentityResponseVO : getIdentityResponseVOArray) {
            if (getIdentityResponseVO.getFields().isPresent()) {

                for (FieldVO fieldVO : getIdentityResponseVO.getFields().get()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testSychronousIdentitiesService_GetIdentityById() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        GetIdentityResponseVO[] getIdentityResponseVOArray = identitiesService.getIdentitiesSync();
        assertThat(getIdentityResponseVOArray).isNotNull();

        Integer identityId = getIdentityResponseVOArray[0].getId().get();

        GetIdentityResponseVO getIdentityByIdResponseVO = identitiesService.getIdentitySync(identityId);
        assertThat(getIdentityByIdResponseVO).isNotNull();

        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (FieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentityById() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        CompletableFuture<GetIdentityResponseVO[]> getIdentityResponseVOArrayCf = identitiesService.getIdentitiesAsync();
        assertThat(getIdentityResponseVOArrayCf).isNotNull();
        assertThat(getIdentityResponseVOArrayCf.get()).isNotNull();
        GetIdentityResponseVO[] getIdentityResponseVOArray = getIdentityResponseVOArrayCf.get();

        Integer identityId = getIdentityResponseVOArray[0].getId().get();

        CompletableFuture<GetIdentityResponseVO>  getIdentityByIdResponseVOCf = identitiesService.getIdentityAsync(identityId);
        assertThat(getIdentityByIdResponseVOCf).isNotNull();
        assertThat(getIdentityByIdResponseVOCf.get()).isNotNull();
        GetIdentityResponseVO  getIdentityByIdResponseVO = getIdentityByIdResponseVOCf.get();

        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (FieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }
    }

    @Test
    public void testSychronousIdentitiesService_CreateIdentity() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CreateIdentityResponseVO createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestVO);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        GetIdentityResponseVO getIdentityByIdResponseVO = identitiesService.getIdentitySync(identityId);
        assertThat(getIdentityByIdResponseVO).isNotNull();

        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (FieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }

        Boolean deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_CreateIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CompletableFuture<CreateIdentityResponseVO> createIdentityResponseVOCf = identitiesService.createIdentityAsync(createIdentityRequestVO);
        assertThat(createIdentityResponseVOCf).isNotNull();
        assertThat(createIdentityResponseVOCf.get()).isNotNull();

        CreateIdentityResponseVO createIdentityResponseVO = createIdentityResponseVOCf.get();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        CompletableFuture<GetIdentityResponseVO> getIdentityByIdResponseVOCf = identitiesService.getIdentityAsync(identityId);
        assertThat(getIdentityByIdResponseVOCf).isNotNull();
        assertThat(getIdentityByIdResponseVOCf.get()).isNotNull();

        GetIdentityResponseVO getIdentityByIdResponseVO = getIdentityByIdResponseVOCf.get();
        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (FieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }

        CompletableFuture<Boolean> deleteIdentityResult = identitiesService.deleteIdentityAsync(identityId);
        assertThat(deleteIdentityResult).isNotNull();
        assertThat(deleteIdentityResult.get()).isNotNull();
        assertThat(deleteIdentityResult.get()).isTrue();
    }

    @Test
    public void testSychronousIdentitiesService_DeleteIdentity() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CreateIdentityResponseVO createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestVO);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        Boolean deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_DeleteIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CompletableFuture<CreateIdentityResponseVO> createIdentityResponseVOCf = identitiesService.createIdentityAsync(createIdentityRequestVO);
        assertThat(createIdentityResponseVOCf).isNotNull();
        assertThat(createIdentityResponseVOCf.get()).isNotNull();

        CreateIdentityResponseVO createIdentityResponseVO = createIdentityResponseVOCf.get();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        CompletableFuture<Boolean> deleteIdentityResultCf = identitiesService.deleteIdentityAsync(identityId);
        assertThat(deleteIdentityResultCf).isNotNull();
        assertThat(deleteIdentityResultCf.get()).isNotNull();
        assertThat(deleteIdentityResultCf.get()).isTrue();
    }

    @Test
    public void testSychronousIdentitiesService_UpdateIdentity() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CreateIdentityResponseVO createIdentityResponseVO = identitiesService.createIdentitySync(createIdentityRequestVO);
        assertThat(createIdentityResponseVO).isNotNull();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        FieldVO field1 = new FieldVO(Optional.of("player_name"), Optional.of("Player Ten"), Optional.of(1), Optional.of(1), Optional.of(1));
        FieldVO field2 = new FieldVO(Optional.of("New Field"), Optional.of("New Field Data"), Optional.of(1), Optional.of(1), Optional.of(1));
        FieldVO[] fieldsArray = new FieldVO[] {field1, field2};
        Optional<FieldVO[]> fields = Optional.of(fieldsArray);

        UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO(fields);
        UpdateIdentityResponseVO updateIdentityResponseVO = identitiesService.updateIdentitySync(updateIdentityRequestVO , identityId);
        assertThat(updateIdentityResponseVO).isNotNull();
        assertThat(updateIdentityResponseVO.getId()).isNotNull();
        assertThat(updateIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(updateIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(updateIdentityResponseVO.getUpdatedAt()).isNotNull();
        //assertThat(updateIdentityResponseVO.getUserId()).isNotNull();
        assertThat(updateIdentityResponseVO.getLinkingCode()).isNotNull();

        Boolean deleteIdentityResult = identitiesService.deleteIdentitySync(identityId);
        assertThat(deleteIdentityResult).isTrue();
    }

    @Test
    public void testAsychronousIdentitiesService_UpdateIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        Optional<String> ethereumAddress = Optional.of("TestEthereumAddress_"+System.currentTimeMillis());
        CreateIdentityRequestVO createIdentityRequestVO = new CreateIdentityRequestVO(ethereumAddress, null);
        CompletableFuture<CreateIdentityResponseVO> createIdentityResponseVOCf = identitiesService.createIdentityAsync(createIdentityRequestVO);
        assertThat(createIdentityResponseVOCf).isNotNull();
        assertThat(createIdentityResponseVOCf.get()).isNotNull();

        CreateIdentityResponseVO createIdentityResponseVO = createIdentityResponseVOCf.get();
        assertThat(createIdentityResponseVO.getId()).isNotNull();
        assertThat(createIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(createIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(createIdentityResponseVO.getUpdatedAt()).isNotNull();

        Integer identityId = createIdentityResponseVO.getId().get();

        FieldVO field1 = new FieldVO(Optional.of("player_name"), Optional.of("Player Ten"), Optional.of(1), Optional.of(1), Optional.of(1));
        FieldVO field2 = new FieldVO(Optional.of("New Field"), Optional.of("New Field Data"), Optional.of(1), Optional.of(1), Optional.of(1));
        FieldVO[] fieldsArray = new FieldVO[] {field1, field2};
        Optional<FieldVO[]> fields = Optional.of(fieldsArray);

        UpdateIdentityRequestVO updateIdentityRequestVO = new UpdateIdentityRequestVO(fields);
        CompletableFuture<UpdateIdentityResponseVO> updateIdentityResponseVOCf = identitiesService.updateIdentityAsync(updateIdentityRequestVO , identityId);
        assertThat(updateIdentityResponseVOCf).isNotNull();
        assertThat(updateIdentityResponseVOCf.get()).isNotNull();

        UpdateIdentityResponseVO updateIdentityResponseVO = updateIdentityResponseVOCf.get();
        assertThat(updateIdentityResponseVO.getId()).isNotNull();
        assertThat(updateIdentityResponseVO.getEthereumAddress()).isNotNull();
        assertThat(updateIdentityResponseVO.getCreatedAt()).isNotNull();
        assertThat(updateIdentityResponseVO.getUpdatedAt()).isNotNull();
        //assertThat(updateIdentityResponseVO.getUserId()).isNotNull();
        assertThat(updateIdentityResponseVO.getLinkingCode()).isNotNull();

        CompletableFuture<Boolean> deleteIdentityResultCf = identitiesService.deleteIdentityAsync(identityId);
        assertThat(deleteIdentityResultCf).isNotNull();
        assertThat(deleteIdentityResultCf.get()).isNotNull();
        assertThat(deleteIdentityResultCf.get()).isTrue();
    }

}
