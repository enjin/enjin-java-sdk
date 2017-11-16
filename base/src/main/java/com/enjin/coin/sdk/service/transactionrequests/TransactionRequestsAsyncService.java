package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.vo.transactionrequest.*;

import java.util.concurrent.Future;

public interface TransactionRequestsAsyncService extends TransactionRequestsService {

    /**
     * Method to get an transactionRequest
     *
     * @param getTransactionRequestRequestVO - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    Future<GetTransactionRequestResponseVO> getTransactionRequestAsync(GetTransactionRequestRequestVO getTransactionRequestRequestVO);

    /**
     * Method to list the transactionRequests
     *
     * @param listTransactionRequestsRequestVO - list the transactionRequest request vo's
     * @return - ListTransactionRequestsResponseVO array
     */
    Future<ListTransactionRequestsResponseVO[]> listTransactionRequestsAsync(ListTransactionRequestsRequestVO listTransactionRequestsRequestVO);

    /**
     * Method to create an transactionRequest
     *
     * @param createTransactionRequestRequestVO - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    Future<CreateTransactionRequestResponseVO> createTransactionRequestAsync(CreateTransactionRequestRequestVO createTransactionRequestRequestVO);

    /**
     * Method to cancel an transactionRequest
     *
     * @param cancelTransactionRequestRequestVO - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    Future<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO);

}
