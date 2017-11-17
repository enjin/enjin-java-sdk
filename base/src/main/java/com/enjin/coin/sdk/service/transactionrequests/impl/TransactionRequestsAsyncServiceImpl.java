package com.enjin.coin.sdk.service.transactionrequests.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsAsyncService;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

import java.util.concurrent.Future;

/**
 * <p>Contains services related to transaction requests</p>
 */
public class TransactionRequestsAsyncServiceImpl extends TransactionRequestsServiceImpl implements TransactionRequestsAsyncService {

    /**
     * Class constructor
     *
     * @param config - the config to use
     */
    public TransactionRequestsAsyncServiceImpl(Config config) {
        super(config);
    }

    public Future<GetTransactionRequestResponseVO> getTransactionRequestAsync(GetTransactionRequestRequestVO request) {
        return executorService.submit(() -> getTransactionRequest(request));
    }

    public Future<ListTransactionRequestsResponseVO[]> listTransactionRequestsAsync(ListTransactionRequestsRequestVO request) {
        return executorService.submit(() -> listTransactionRequests(request));
    }

    public Future<CreateTransactionRequestResponseVO> createTransactionRequestAsync(CreateTransactionRequestRequestVO request) {
        return executorService.submit(() -> createTransactionRequest(request));
    }

    public Future<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(CancelTransactionRequestRequestVO request) {
        return executorService.submit(() -> cancelTransactionRequest(request));
    }

}
