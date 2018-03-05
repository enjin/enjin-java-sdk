package io.enjincoin.sdk.client.service.transactions;

import java.io.IOException;

import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.ExecuteTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.TransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionResponseBody;
import retrofit2.Response;

public interface SynchronousTransactionsService {

    Response<TransactionResponseBody[]> getTransactionsSync() throws IOException;

    Response<TransactionResponseBody> getTransactionSync(long transactionId) throws IOException;

    Response<CreateTransactionResponseBody> createTransactionSync(CreateTransactionRequestBody createTransactionRequestVO) throws IOException;

    Response<UpdateTransactionResponseBody> updateTransactionSync(long transactionId, UpdateTransactionRequestBody updateTransactionRequest) throws IOException;

    Response<Boolean> deleteTransactionSync(long transactionId) throws IOException;

    Response<Boolean> executeTransactionSync(long transactionId, ExecuteTransactionRequestBody executeTransactionRequest) throws IOException;

    Response<Boolean> cancelTransactionSync(long transactionId) throws IOException;
}
