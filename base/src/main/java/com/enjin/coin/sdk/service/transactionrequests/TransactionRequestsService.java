package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.vo.transactionrequest.*;

public interface TransactionRequestsService {

    /**
     * Method to get an transactionRequest
     *
     * @param getTransactionRequestRequestVO - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    GetTransactionRequestResponseVO getTransactionRequest(GetTransactionRequestRequestVO getTransactionRequestRequestVO);

    /**
     * Method to list the transactionRequests
     *
     * @param listTransactionRequestsRequestVO - list the transactionRequest request vo's
     * @return - ListTransactionRequestsResponseVO array
     */
    ListTransactionRequestsResponseVO[] listTransactionRequests(ListTransactionRequestsRequestVO listTransactionRequestsRequestVO);

    /**
     * Method to create an transactionRequest
     *
     * @param createTransactionRequestRequestVO - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    CreateTransactionRequestResponseVO createTransactionRequest(CreateTransactionRequestRequestVO createTransactionRequestRequestVO);

    /**
     * Method to cancel an transactionRequest
     *
     * @param cancelTransactionRequestRequestVO - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    CancelTransactionRequestResponseVO cancelTransactionRequest(CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO);

}
