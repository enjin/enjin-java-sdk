package com.enjin.coin.sdk.service.transactionrequests.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsAsyncService;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;

/**
 * <p>
 * Contains services related to transaction requests.
 * </p>
 */
public final class TransactionRequestsAsyncServiceImpl extends TransactionRequestsServiceImpl implements TransactionRequestsAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public TransactionRequestsAsyncServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public CompletableFuture<GetTransactionRequestResponseVO[]> getTransactionRequestAsync(final GetTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> getTransactionRequest(request), getExecutorService());
    }

    @Override
    public CompletableFuture<CreateTransactionRequestResponseVO> createTransactionRequestAsync(final CreateTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> createTransactionRequest(request), getExecutorService());
    }

    @Override
    public CompletableFuture<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(final CancelTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> cancelTransactionRequest(request), getExecutorService());
    }

}
