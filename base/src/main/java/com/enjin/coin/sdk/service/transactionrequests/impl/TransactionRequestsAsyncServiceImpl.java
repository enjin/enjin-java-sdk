package com.enjin.coin.sdk.service.transactionrequests.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsAsyncService;
import com.enjin.coin.sdk.vo.transactionrequest.*;

import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * <p>Contains services related to transaction requests</p>
 */
public class TransactionRequestsAsyncServiceImpl extends TransactionRequestsServiceImpl implements TransactionRequestsAsyncService {

    private static final Logger LOGGER = Logger.getLogger(TransactionRequestsAsyncServiceImpl.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig - the enjinConfig to use
     */
    public TransactionRequestsAsyncServiceImpl(Config enjinConfig) {
        super(enjinConfig);
    }

    public Future<GetTransactionRequestResponseVO> getTransactionRequestAsync(GetTransactionRequestRequestVO getTransactionRequestRequestVO) {
        return executorService.submit(() -> getTransactionRequest(getTransactionRequestRequestVO));
    }

    public Future<ListTransactionRequestsResponseVO[]> listTransactionRequestsAsync(ListTransactionRequestsRequestVO listTransactionRequestsRequestVO) {
        return executorService.submit(() -> listTransactionRequests(listTransactionRequestsRequestVO));
    }

    public Future<CreateTransactionRequestResponseVO> createTransactionRequestAsync(CreateTransactionRequestRequestVO createTransactionRequestRequestVO) {
        return executorService.submit(() -> createTransactionRequest(createTransactionRequestRequestVO));
    }

    public Future<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO) {
        return executorService.submit(() -> cancelTransactionRequest(cancelTransactionRequestRequestVO));
    }

}
