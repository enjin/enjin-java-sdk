package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;

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
