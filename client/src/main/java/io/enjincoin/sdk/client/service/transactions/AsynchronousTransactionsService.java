package io.enjincoin.sdk.client.service.transactions;

import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.ExecuteTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.TransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionResponseBody;
import retrofit2.Callback;

public interface AsynchronousTransactionsService {

    void getTransactionsAsync(Callback<TransactionResponseBody[]> callback);

    void getTransactionAsync(long transactionId, Callback<TransactionResponseBody> callback);

    void createTransactionAsync(CreateTransactionRequestBody createTransactionRequestVO, Callback<CreateTransactionResponseBody> callback);

    void updateTransactionAsync(long transactionId, UpdateTransactionRequestBody updateTransactionRequest, Callback<UpdateTransactionResponseBody> callback);

    void deleteTransactionAsync(long transactionId, Callback<Boolean> callback);

    void executeTransactionAsync(long transactionId, ExecuteTransactionRequestBody executeTransactionRequest, Callback<Boolean> callback);

    void cancelTransactionAsync(long transactionId, Callback<Boolean> callback);
}
