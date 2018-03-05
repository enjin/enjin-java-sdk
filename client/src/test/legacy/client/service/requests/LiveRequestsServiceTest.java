package client.service.requests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.requests.AsynchronousRequestsService;
import io.enjincoin.sdk.client.service.requests.SynchronousRequestsService;
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
}
