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
 * <p>Contains services related to transaction requests.</p>
 */
public final class TransactionRequestsAsyncServiceImpl extends TransactionRequestsServiceImpl
        implements TransactionRequestsAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public TransactionRequestsAsyncServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public Future<GetTransactionRequestResponseVO> getTransactionRequestAsync(
            final GetTransactionRequestRequestVO request
    ) {
        return getExecutorService().submit(() -> getTransactionRequest(request));
    }

    @Override
    public Future<ListTransactionRequestsResponseVO[]> listTransactionRequestsAsync(
            final ListTransactionRequestsRequestVO request
    ) {
        return getExecutorService().submit(() -> listTransactionRequests(request));
    }

    @Override
    public Future<CreateTransactionRequestResponseVO> createTransactionRequestAsync(
            final CreateTransactionRequestRequestVO request
    ) {
        return getExecutorService().submit(() -> createTransactionRequest(request));
    }

    @Override
    public Future<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(
            final CancelTransactionRequestRequestVO request
    ) {
        return getExecutorService().submit(() -> cancelTransactionRequest(request));
    }

}
