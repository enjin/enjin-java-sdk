package client.service.requests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import client.service.BaseLiveServiceTest;
import org.junit.Test;

import io.enjincoin.sdk.client.service.requests.AsynchronousRequestsService;
import io.enjincoin.sdk.client.service.requests.SynchronousRequestsService;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveRequestsServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousRequestsService_GetRequests() throws IOException {
        SynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Response<RequestResponseBody[]> requestsArray = requestsService.getRequestsSync();
        assertThat(requestsArray).isNotNull();
        assertThat(requestsArray.body()).isNotNull();

        for (RequestResponseBody request : requestsArray.body()) {
            assertThat(request).isNotNull();
            assertThat(request.getId()).isNotNull();
            assertThat(request.getTransactionId()).isNotNull();
            assertThat(request.getAppId()).isNotNull();
            assertThat(request.getRecipient()).isNotNull();
            assertThat(request.getIdentity()).isNotNull();
            assertThat(request.getToken()).isNotNull();
        }
    }

    @Test
    public void testAsychronousRequestsService_GetRequests() throws InterruptedException, ExecutionException {
        AsynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        requestsService.getRequestsAsync(new Callback<RequestResponseBody[]>() {

            @Override
            public void onResponse(Call<RequestResponseBody[]> call, Response<RequestResponseBody[]> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                RequestResponseBody[] requestsArray = response.body();
                for (RequestResponseBody request : requestsArray) {
                    assertThat(request).isNotNull();
                    assertThat(request.getId()).isNotNull();
                    assertThat(request.getTransactionId()).isNotNull();
                    assertThat(request.getAppId()).isNotNull();
                    assertThat(request.getRecipient()).isNotNull();
                    assertThat(request.getIdentity()).isNotNull();
                    assertThat(request.getToken()).isNotNull();
                }
            }

            @Override
            public void onFailure(Call<RequestResponseBody[]> call, Throwable t) {
                fail("Test Failed");
            }
        });
    }


    @Test
    public void testSynchronousRequestsService_GetRequest() throws IOException {
        SynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        Response<CreateRequestResponseBody> createRequestResponseBody = requestsService.createRequestSync(createRequestRequestVO);
        assertThat(createRequestResponseBody).isNotNull();
        assertThat(createRequestResponseBody.body()).isNotNull();
        assertThat(createRequestResponseBody.body().getId().get()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId().get();

        Response<RequestResponseBody> request = requestsService.getRequestSync(requestId);
        assertThat(request).isNotNull();
        assertThat(request.body()).isNotNull();

        assertThat(request).isNotNull();
        assertThat(request.body()).isNotNull();
        assertThat(request.body().getId()).isNotNull();
        assertThat(request.body().getTransactionId()).isNotNull();
        assertThat(request.body().getAppId()).isNotNull();
        assertThat(request.body().getRecipient()).isNotNull();
        assertThat(request.body().getIdentity()).isNotNull();
        assertThat(request.body().getToken()).isNotNull();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousRequestsService_GetRequest() throws InterruptedException, ExecutionException {
        AsynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        requestsService.createRequestAsync(createRequestRequestVO, new Callback<CreateRequestResponseBody>() {

            @Override
            public void onResponse(Call<CreateRequestResponseBody> call, Response<CreateRequestResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();
                assertThat(response.body().getId().get()).isNotNull();

                Integer requestId = response.body().getId().get();

                requestsService.getRequestAsync(requestId, new Callback<RequestResponseBody>() {
                    @Override
                    public void onResponse(Call<RequestResponseBody> call, Response<RequestResponseBody> response) {
                        assertThat(response).isNotNull();
                        assertThat(response.body()).isNotNull();

                        RequestResponseBody request = response.body();
                        assertThat(request).isNotNull();
                        assertThat(request.getId()).isNotNull();
                        assertThat(request.getTransactionId()).isNotNull();
                        assertThat(request.getAppId()).isNotNull();
                        assertThat(request.getRecipient()).isNotNull();
                        assertThat(request.getIdentity()).isNotNull();
                        assertThat(request.getToken()).isNotNull();

                        requestsService.deleteRequestAsync(requestId, new Callback<Boolean>() {

                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                                assertThat(deleteResponse).isNotNull();
                                assertThat(deleteResponse.body()).isNotNull();
                                assertThat(deleteResponse.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }

                        });
                    }

                    @Override
                    public void onFailure(Call<RequestResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }
                });
            }

            @Override
            public void onFailure(Call<CreateRequestResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
     }

    @Test
    public void testSynchronousRequestsService_CreateRequest() throws IOException {
        SynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        Response<CreateRequestResponseBody> createRequestResponseBody = requestsService.createRequestSync(createRequestRequestVO);
        assertThat(createRequestResponseBody).isNotNull();
        assertThat(createRequestResponseBody.body()).isNotNull();
        assertThat(createRequestResponseBody.body().getId().get()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId().get();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousRequestsService_CreateRequest() throws InterruptedException, ExecutionException {
        AsynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        requestsService.createRequestAsync(createRequestRequestVO, new Callback<CreateRequestResponseBody>() {

            @Override
            public void onResponse(Call<CreateRequestResponseBody> call, Response<CreateRequestResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();
                assertThat(response.body().getId().get()).isNotNull();

                Integer requestId = response.body().getId().get();

                requestsService.deleteRequestAsync(requestId, new Callback<Boolean>() {

                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                        assertThat(deleteResponse).isNotNull();
                        assertThat(deleteResponse.body()).isNotNull();
                        assertThat(deleteResponse.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }

                });
            }

            @Override
            public void onFailure(Call<CreateRequestResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
     }

    @Test
    public void testSynchronousRequestsService_DeleteRequest() throws IOException {
        SynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        Response<CreateRequestResponseBody> createRequestResponseBody = requestsService.createRequestSync(createRequestRequestVO);
        assertThat(createRequestResponseBody).isNotNull();
        assertThat(createRequestResponseBody.body()).isNotNull();
        assertThat(createRequestResponseBody.body().getId().get()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId().get();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousRequestsService_DeleteRequest() throws InterruptedException, ExecutionException {
        AsynchronousRequestsService requestsService = this.client.getRequestsService();
        assertThat(requestsService).isNotNull();

        Integer identityId = 1;
        Integer tokenId = 1;
        Integer appId = 1;
        String value = "10.2";
        Integer recipientId = 1;
        CreateRequestRequestBody createRequestRequestVO = new CreateRequestRequestBody(identityId, tokenId, appId, value, recipientId);
        requestsService.createRequestAsync(createRequestRequestVO, new Callback<CreateRequestResponseBody>() {

            @Override
            public void onResponse(Call<CreateRequestResponseBody> call, Response<CreateRequestResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();
                assertThat(response.body().getId().get()).isNotNull();

                Integer requestId = response.body().getId().get();

                requestsService.deleteRequestAsync(requestId, new Callback<Boolean>() {

                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                        assertThat(deleteResponse).isNotNull();
                        assertThat(deleteResponse.body()).isNotNull();
                        assertThat(deleteResponse.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }

                });
            }

            @Override
            public void onFailure(Call<CreateRequestResponseBody> call, Throwable t) {
                fail("Test Failed");
            }

        });
     }
}
