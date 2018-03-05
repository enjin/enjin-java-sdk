package client.service.transactions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.transactions.AsynchronousTransactionsService;
import io.enjincoin.sdk.client.service.transactions.SynchronousTransactionsService;
import io.enjincoin.sdk.client.service.transactions.vo.TransactionResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveTransactionsServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousTransactionsService_GetTransactions() throws IOException {
        SynchronousTransactionsService transactionsService = this.client.getTransactionsService();
        assertThat(transactionsService).isNotNull();

        Response<TransactionResponseBody[]> transactionsArray = transactionsService.getTransactionsSync();
        assertThat(transactionsArray).isNotNull();
        assertThat(transactionsArray.body()).isNotNull();

        for (TransactionResponseBody transaction : transactionsArray.body()) {
            assertThat(transaction).isNotNull();
            assertThat(transaction.getId()).isNotNull();
            assertThat(transaction.getTransactionId()).isNotNull();
            assertThat(transaction.getAppId()).isNotNull();
            assertThat(transaction.getRecipient()).isNotNull();
            assertThat(transaction.getIdentity()).isNotNull();
            assertThat(transaction.getToken()).isNotNull();
        }
    }

    @Test
    public void testAsychronousTransactionsService_GetTransactions() throws InterruptedException, ExecutionException {
        AsynchronousTransactionsService transactionsService = this.client.getTransactionsService();
        assertThat(transactionsService).isNotNull();

        transactionsService.getTransactionsAsync(new Callback<TransactionResponseBody[]>() {

            @Override
            public void onResponse(Call<TransactionResponseBody[]> call, Response<TransactionResponseBody[]> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                TransactionResponseBody[] transactionsArray = response.body();
                for (TransactionResponseBody transaction : transactionsArray) {
                    assertThat(transaction).isNotNull();
                    assertThat(transaction.getId()).isNotNull();
                    assertThat(transaction.getTransactionId()).isNotNull();
                    assertThat(transaction.getAppId()).isNotNull();
                    assertThat(transaction.getRecipient()).isNotNull();
                    assertThat(transaction.getIdentity()).isNotNull();
                    assertThat(transaction.getToken()).isNotNull();
                }
            }

            @Override
            public void onFailure(Call<TransactionResponseBody[]> call, Throwable t) {
                fail("Test Failed");
            }
        });
    }
}
