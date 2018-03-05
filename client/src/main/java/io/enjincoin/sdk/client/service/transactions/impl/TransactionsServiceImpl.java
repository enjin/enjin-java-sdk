package io.enjincoin.sdk.client.service.transactions.impl;

import java.io.IOException;

import io.enjincoin.sdk.client.service.transactions.TransactionsService;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.CreateTransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.ExecuteTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.TransactionResponseBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionRequestBody;
import io.enjincoin.sdk.client.service.transactions.vo.UpdateTransactionResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TransactionsServiceImpl implements TransactionsService{

    private RetrofitTransactionsService service;

    public TransactionsServiceImpl(Retrofit retrofit) {
        this.service = retrofit.create(RetrofitTransactionsService.class);
    }

    @Override
    public void getTransactionsAsync(Callback<TransactionResponseBody[]> callback) {
        Call<TransactionResponseBody[]> call = this.service.getTransactions();
        call.enqueue(callback);
    }

    @Override
    public void getTransactionAsync(long transactionId, Callback<TransactionResponseBody> callback) {
        Call<TransactionResponseBody> call = this.service.getTransaction(transactionId);
        call.enqueue(callback);
    }

    @Override
    public void createTransactionAsync(CreateTransactionRequestBody createTransactionRequestVO, Callback<CreateTransactionResponseBody> callback) {
        Call<CreateTransactionResponseBody> call = this.service.createTransaction(createTransactionRequestVO);
        call.enqueue(callback);
    }

    @Override
    public void updateTransactionAsync(long transactionId, UpdateTransactionRequestBody updateTransactionRequest, Callback<UpdateTransactionResponseBody> callback) {
        Call<UpdateTransactionResponseBody> call = this.service.updateTransaction(transactionId, updateTransactionRequest);
        call.enqueue(callback);
    }

    @Override
    public void deleteTransactionAsync(long transactionId, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.deleteTransaction(transactionId);
        call.enqueue(callback);
    }

    @Override
    public void executeTransactionAsync(long transactionId, ExecuteTransactionRequestBody executeTransactionRequest, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.executeTransaction(transactionId, executeTransactionRequest);
        call.enqueue(callback);
    }

    @Override
    public void cancelTransactionAsync(long transactionId, Callback<Boolean> callback) {
        Call<Boolean> call = this.service.cancelTransaction(transactionId);
        call.enqueue(callback);
    }

    @Override
    public Response<TransactionResponseBody[]> getTransactionsSync() throws IOException {
        Call<TransactionResponseBody[]> call = this.service.getTransactions();
        return call.execute();
    }

    @Override
    public Response<TransactionResponseBody> getTransactionSync(long transactionId) throws IOException {
        Call<TransactionResponseBody> call = this.service.getTransaction(transactionId);
        return call.execute();
    }

    @Override
    public Response<CreateTransactionResponseBody> createTransactionSync(CreateTransactionRequestBody createTransactionRequestVO) throws IOException {
        Call<CreateTransactionResponseBody> call = this.service.createTransaction(createTransactionRequestVO);
        return call.execute();
    }

    @Override
    public Response<UpdateTransactionResponseBody> updateTransactionSync(long transactionId, UpdateTransactionRequestBody updateTransactionRequest) throws IOException {
        Call<UpdateTransactionResponseBody> call = this.service.updateTransaction(transactionId, updateTransactionRequest);
        return call.execute();
    }

    @Override
    public Response<Boolean> deleteTransactionSync(long transactionId) throws IOException {
        Call<Boolean> call = this.service.deleteTransaction(transactionId);
        return call.execute();
    }

    @Override
    public Response<Boolean> executeTransactionSync(long transactionId, ExecuteTransactionRequestBody executeTransactionRequest) throws IOException {
        Call<Boolean> call = this.service.executeTransaction(transactionId, executeTransactionRequest);
        return call.execute();
    }

    @Override
    public Response<Boolean> cancelTransactionSync(long transactionId) throws IOException {
        Call<Boolean> call = this.service.cancelTransaction(transactionId);
        return call.execute();
    }


}
