package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

public interface TransactionRequestsService {

    /**
     * Method to get an transactionRequest
     *
     * @param request - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    GetTransactionRequestResponseVO getTransactionRequest(GetTransactionRequestRequestVO request);

    /**
     * Method to list the transactionRequests
     *
     * @param request - list the transactionRequest request vo's
     * @return - ListTransactionRequestsResponseVO array
     */
    ListTransactionRequestsResponseVO[] listTransactionRequests(ListTransactionRequestsRequestVO request);

    /**
     * Method to create an transactionRequest
     *
     * @param request - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    CreateTransactionRequestResponseVO createTransactionRequest(CreateTransactionRequestRequestVO request);

    /**
     * Method to cancel an transactionRequest
     *
     * @param request - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    CancelTransactionRequestResponseVO cancelTransactionRequest(CancelTransactionRequestRequestVO request);

}
