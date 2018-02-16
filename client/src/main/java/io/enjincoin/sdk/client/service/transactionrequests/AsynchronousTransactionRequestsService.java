package io.enjincoin.sdk.client.service.transactionrequests;

import io.enjincoin.sdk.client.vo.transactionrequest.*;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous TransactionRequests service interface.
 */
public interface AsynchronousTransactionRequestsService extends SynchronousTransactionRequestsService {

    /**
     * Method to get an transactionRequest.
     *
     * @param request - get the transactionRequest request vo
     *
     * @return - GetTransactionRequestResponseVO
     */
    CompletableFuture<GetTransactionRequestResponseVO[]> getTransactionRequestsAsync(GetTransactionRequestRequestVO request);

    /**
     * Method to create an transactionRequest.
     *
     * @param request - create the transactionRequest request vo
     *
     * @return - CreateTransactionRequestResponseVO
     */
    CompletableFuture<CreateTransactionRequestResponseVO> createTransactionRequestAsync(CreateTransactionRequestRequestVO request);

    /**
     * Method to cancel an transactionRequest.
     *
     * @param request - cancel the transactionRequest request vo
     *
     * @return - CancelTransactionRequestResponseVO
     */
    CompletableFuture<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(CancelTransactionRequestRequestVO request);

}
