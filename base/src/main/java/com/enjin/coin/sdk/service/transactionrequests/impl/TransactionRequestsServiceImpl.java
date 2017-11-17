package com.enjin.coin.sdk.service.transactionrequests.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Contains services related to transaction requests.</p>
 */
public class TransactionRequestsServiceImpl extends BaseService implements TransactionRequestsService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(TransactionRequestsServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the enjinConfig to use
     */
    public TransactionRequestsServiceImpl(final Config config) {
        super(config);
    }

    /**
     * Method to get an transactionRequest.
     *
     * @param request - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    public GetTransactionRequestResponseVO getTransactionRequest(final GetTransactionRequestRequestVO request) {
        GetTransactionRequestResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.get request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || StringUtils.isEmpty(request.getTxrId())) {
            LOGGER.warning("TransactionRequests.get parameters may be empty or null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("txr_id", request.getTxrId().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_GET;

        response = (GetTransactionRequestResponseVO) jsonRpcUtils
                .sendJsonRpcRequest(getTransactionRequestsUrl(), GetTransactionRequestResponseVO.class, method, params);

        return response;
    }

    /**
     * Method to list the transactionRequests.
     *
     * @param request - list the transactionRequest request vo's
     * @return - ListTransactionRequestsResponseVO array
     */
    public ListTransactionRequestsResponseVO[] listTransactionRequests(final ListTransactionRequestsRequestVO request) {
        ListTransactionRequestsResponseVO[] response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.list request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())
                || StringUtils.isEmpty(request.getAppId()) || MapUtils.isEmpty(request.getRecipientMap())
                || StringUtils.isEmpty(request.getType()) || StringUtils.isEmpty(request.getAfterTxrId())
                || StringUtils.isEmpty(request.getLimit()) || StringUtils.isEmpty(request.getCurrency())) {
            LOGGER.warning("TransactionRequests.list parameters may be empty or null.");
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
        String method = Constants.METHOD_TRANSACTION_REQUESTS_LIST;

        response = (ListTransactionRequestsResponseVO[]) jsonRpcUtils
                .sendJsonRpcRequest(getTransactionRequestsUrl(), ListTransactionRequestsResponseVO[].class,
                        method, params);

        return response;
    }

    /**
     * Method to create an transactionRequest.
     *
     * @param request - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    public CreateTransactionRequestResponseVO createTransactionRequest(
            final CreateTransactionRequestRequestVO request
    ) {
        CreateTransactionRequestResponseVO response = null;

        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("TransactionRequests.create request is null.");
            return response;
        }

        if (StringUtils.isEmpty(request.getAuth()) || MapUtils.isEmpty(request.getIdentityMap())
                || MapUtils.isEmpty(request.getRecipientMap()) || StringUtils.isEmpty(request.getType())
                || StringUtils.isEmpty(request.getIcon()) || StringUtils.isEmpty(request.getTitle())
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

        response = (CreateTransactionRequestResponseVO) jsonRpcUtils
                .sendJsonRpcRequest(getTransactionRequestsUrl(), CreateTransactionRequestResponseVO.class,
                        method, params);

        return response;
    }

    /**
     * Method to cancel an transactionRequest.
     *
     * @param request - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    public CancelTransactionRequestResponseVO cancelTransactionRequest(
            final CancelTransactionRequestRequestVO request
    ) {
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

        Boolean result = (Boolean) jsonRpcUtils
                .sendJsonRpcRequest(getTransactionRequestsUrl(), Boolean.class, method, params);

        response = ImmutableCancelTransactionRequestResponseVO.builder()
                .setResult(result)
                .build();

        return response;
    }

}