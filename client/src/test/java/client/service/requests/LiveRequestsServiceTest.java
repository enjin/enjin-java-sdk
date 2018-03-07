package client.service.requests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.requests.AsynchronousRequestsService;
import io.enjincoin.sdk.client.service.requests.SynchronousRequestsService;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.CreateRequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.ExecuteRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.RequestResponseBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestRequestBody;
import io.enjincoin.sdk.client.service.requests.vo.UpdateRequestResponseBody;
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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();

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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();

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
    public void testSynchronousRequestsService_UpdateRequest() throws IOException {
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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

        UpdateRequestRequestBody updateRequestRequest = new UpdateRequestRequestBody("value", 1);
        Response<UpdateRequestResponseBody> updateRequestResponseBody = requestsService.updateRequestSync(requestId, updateRequestRequest );
        assertThat(updateRequestResponseBody).isNotNull();
        assertThat(updateRequestResponseBody.body()).isNotNull();
        assertThat(updateRequestResponseBody.body().getId()).isNotNull();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }


    @Test
    public void testAsychronousRequestsService_UpdateRequest() throws InterruptedException, ExecutionException {
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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();


                UpdateRequestRequestBody updateRequestRequest = new UpdateRequestRequestBody("value", 1);
                requestsService.updateRequestAsync(requestId, updateRequestRequest, new Callback<UpdateRequestResponseBody>() {

                    @Override
                    public void onResponse(Call<UpdateRequestResponseBody> call, Response<UpdateRequestResponseBody> updateRequestResponseBody) {
                        assertThat(updateRequestResponseBody).isNotNull();
                        assertThat(updateRequestResponseBody.body()).isNotNull();
                        assertThat(updateRequestResponseBody.body().getId()).isNotNull();
                    }

                    @Override
                    public void onFailure(Call<UpdateRequestResponseBody> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();

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
    public void testSynchronousRequestsService_ExecuteRequest() throws IOException {
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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

        String data = createRequestRequestVO.getValue();
        ExecuteRequestRequestBody executeRequestRequest = new ExecuteRequestRequestBody(data);
        Response<Boolean> executeRequestResponseBody = requestsService.executeRequestSync(requestId, executeRequestRequest);
        assertThat(executeRequestResponseBody).isNotNull();
        assertThat(executeRequestResponseBody.body()).isTrue();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }


    @Test
    public void testAsychronousRequestsService_ExecuteRequest() throws InterruptedException, ExecutionException {
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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();


                String data = createRequestRequestVO.getValue();
                ExecuteRequestRequestBody executeRequestRequest = new ExecuteRequestRequestBody(data);

                requestsService.executeRequestAsync(requestId, executeRequestRequest, new Callback<Boolean>() {

                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> executeRequestResponseBody) {
                        assertThat(executeRequestResponseBody).isNotNull();
                        assertThat(executeRequestResponseBody.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

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
    public void testSynchronousRequestsService_CancelRequest() throws IOException {
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
        assertThat(createRequestResponseBody.body().getId()).isNotNull();

        Integer requestId = createRequestResponseBody.body().getId();

        Response<Boolean> cancelRequestResponseBody = requestsService.cancelRequestSync(requestId);
        assertThat(cancelRequestResponseBody).isNotNull();
        assertThat(cancelRequestResponseBody.body()).isTrue();

        Response<Boolean> deleteResponse = requestsService.deleteRequestSync(requestId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }


    @Test
    public void testAsychronousRequestsService_CancelRequest() throws InterruptedException, ExecutionException {
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
                assertThat(response.body().getId()).isNotNull();

                Integer requestId = response.body().getId();

                requestsService.cancelRequestAsync(requestId, new Callback<Boolean>() {

                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> cancelRequestResponseBody) {
                        assertThat(cancelRequestResponseBody).isNotNull();
                        assertThat(cancelRequestResponseBody.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }

                });

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
