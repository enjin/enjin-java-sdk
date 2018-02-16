package io.enjincoin.sdk.client.service.transactionrequests.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsAsyncService;
import io.enjincoin.sdk.client.vo.transactionrequest.*;

import java.util.concurrent.CompletableFuture;

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
