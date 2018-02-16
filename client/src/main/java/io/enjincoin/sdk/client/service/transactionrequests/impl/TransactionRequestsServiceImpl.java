package io.enjincoin.sdk.client.service.transactionrequests.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.MapUtils;
import io.enjincoin.sdk.client.util.ObjectUtils;
import io.enjincoin.sdk.client.util.StringUtils;
import io.enjincoin.sdk.client.vo.transactionrequest.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * <p>
 * Contains services related to transaction requests.
 * </p>
 */
public class TransactionRequestsServiceImpl extends BaseService implements TransactionRequestsService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(TransactionRequestsServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public TransactionRequestsServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public final GetTransactionRequestResponseVO[] getTransactionRequestsSync(final GetTransactionRequestRequestVO request) {
        GetTransactionRequestResponseVO[] response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.get request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())) {
            LOGGER.warning("1. TransactionRequests.get parameters may be empty or null.");
            return response;
        }
        if (StringUtils.isEmpty(request.getAppId()) || MapUtils.isEmpty(request.getRecipientMap())) {
            LOGGER.warning("2. TransactionRequests.get parameters may be empty or null.");
            return response;
        }
        if (StringUtils.isEmpty(request.getType()) || StringUtils.isEmpty(request.getAfterTxrId()) || StringUtils.isEmpty(request.getLimit())
                || StringUtils.isEmpty(request.getCurrency())) {
            LOGGER.warning("3. TransactionRequests.get parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());
        params.put("app_id", request.getAppId().get());
        params.put("recipient", request.getRecipientMap().get());
        params.put("type", request.getType().get());
        params.put("after_txr_id", request.getAfterTxrId().get());
        params.put("limit", request.getLimit().get());
        params.put("currency", request.getCurrency().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_GET;

        response = (GetTransactionRequestResponseVO[]) this.getJsonRpcUtils().sendJsonRpcRequest(this.getTransactionRequestsUrl(),
                GetTransactionRequestResponseVO[].class, method, params);

        return response;
    }

    @Override
    public final CreateTransactionRequestResponseVO createTransactionRequestSync(final CreateTransactionRequestRequestVO request) {
        CreateTransactionRequestResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.create request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap()) || MapUtils.isEmpty(request.getRecipientMap())
                || StringUtils.isEmpty(request.getType()) || StringUtils.isEmpty(request.getIcon()) || StringUtils.isEmpty(request.getTitle())
                || MapUtils.isEmpty(request.getValueMap())) {
            LOGGER.warning("TransactionRequests.create parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("identity", request.getIdentityMap().get());
        params.put("recipient", request.getRecipientMap().get());
        params.put("type", request.getType().get());
        params.put("icon", request.getIcon().get());
        params.put("title", request.getTitle().get());
        params.put("value", request.getValueMap().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CREATE;

        response = (CreateTransactionRequestResponseVO) this.getJsonRpcUtils().sendJsonRpcRequest(this.getTransactionRequestsUrl(),
                CreateTransactionRequestResponseVO.class, method, params);

        return response;
    }

    @Override
    public final CancelTransactionRequestResponseVO cancelTransactionRequestSync(final CancelTransactionRequestRequestVO request) {
        CancelTransactionRequestResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.create request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || StringUtils.isEmpty(request.getTxrId())) {
            LOGGER.warning("TransactionRequests.cancel parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("txr_id", request.getTxrId().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CANCEL;

        Boolean result = (Boolean) this.getJsonRpcUtils().sendJsonRpcRequest(this.getTransactionRequestsUrl(), Boolean.class, method, params);

        response = ImmutableCancelTransactionRequestResponseVO.builder().setResult(result).build();

        return response;
    }

    @Override
    public CompletableFuture<GetTransactionRequestResponseVO[]> getTransactionRequestsAsync(final GetTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.getTransactionRequestsSync(request), this.getExecutorService());
    }

    @Override
    public CompletableFuture<CreateTransactionRequestResponseVO> createTransactionRequestAsync(final CreateTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.createTransactionRequestSync(request), this.getExecutorService());
    }

    @Override
    public CompletableFuture<CancelTransactionRequestResponseVO> cancelTransactionRequestAsync(final CancelTransactionRequestRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.cancelTransactionRequestSync(request), this.getExecutorService());
    }

}