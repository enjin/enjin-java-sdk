package com.enjin.coin.sdk.service.transactionrequests;

import java.util.concurrent.Future;

import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;

/**
 * Asynchronous TransactionRequests service interface.
 */
public interface TransactionRequestsAsyncService extends TransactionRequestsService {

    /**
     * Method to get an transactionRequest.
     *
     * @param request - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    Future<GetTransactionRequestResponseVO[]> getTransactionRequestAsync(GetTransactionRequestRequestVO request);

    /**
     * Method to create an transactionRequest.
     *
     * @param request - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    Future<CreateTransactionRequestResponseVO> createTransactionRequestAsync(CreateTransactionRequestRequestVO request);

    /**
     * Method to cancel an transactionRequest.
     *
     * @param request - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    Future<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(CancelTransactionRequestRequestVO request);

}
