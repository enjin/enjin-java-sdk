package io.enjincoin.sdk.client.service.transactionrequests;

import io.enjincoin.sdk.client.vo.transactionrequest.*;

/**
 * TransactionRequests service interface.
 */
public interface TransactionRequestsService {

    /**
     * Method to get an transactionRequest.
     *
     * @param request - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    GetTransactionRequestResponseVO[] getTransactionRequest(GetTransactionRequestRequestVO request);

    /**
     * Method to create an transactionRequest.
     *
     * @param request - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    CreateTransactionRequestResponseVO createTransactionRequest(CreateTransactionRequestRequestVO request);

    /**
     * Method to cancel an transactionRequest.
     *
     * @param request - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    CancelTransactionRequestResponseVO cancelTransactionRequest(CancelTransactionRequestRequestVO request);

}
