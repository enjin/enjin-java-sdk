package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.transactionrequest.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TransactionRequestsService extends BaseService {

    private static final Logger LOGGER = Logger.getLogger(TransactionRequestsService.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig - the enjinConfig to use
     */
    protected TransactionRequestsService(EnjinConfig enjinConfig) {
        super(enjinConfig);
    }

    /**
     * Method to get an transactionRequest
     *
     * @param getTransactionRequestRequestVO - get the transactionRequest request vo
     * @return - GetTransactionRequestResponseVO
     */
    public GetTransactionRequestResponseVO getTransactionRequest(GetTransactionRequestRequestVO getTransactionRequestRequestVO) {
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = null;

        if (ObjectUtils.isNull(getTransactionRequestRequestVO) || StringUtils.isEmpty(getTransactionRequestRequestVO.getAuth())
                || StringUtils.isEmpty(getTransactionRequestRequestVO.getTxrId())) {
            LOGGER.warning("getTransactionRequestRequestVO is null, auth or identidyId passed in are null or empty");
            return getTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", getTransactionRequestRequestVO.getAuth().get());
        params.put("txr_id", getTransactionRequestRequestVO.getTxrId().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_GET;

        getTransactionRequestResponseVO = (GetTransactionRequestResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), GetTransactionRequestResponseVO.class, method, params);

        return getTransactionRequestResponseVO;
    }

    /**
     * Method to list the transactionRequests
     *
     * @param listTransactionRequestsRequestVO - list the transactionRequest request vo's
     * @return - ListTransactionRequestsResponseVO array
     */
    public ListTransactionRequestsResponseVO[] listTransactionRequests(ListTransactionRequestsRequestVO listTransactionRequestsRequestVO) {
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVO = null;

        if (ObjectUtils.isNull(listTransactionRequestsRequestVO) || StringUtils.isEmpty(listTransactionRequestsRequestVO.getAuth())
                || MapUtils.isEmpty(listTransactionRequestsRequestVO.getIdentityMap())
                || StringUtils.isEmpty(listTransactionRequestsRequestVO.getAppId())) {
            LOGGER.warning("listTransactionRequestsRequestVO is null, auth, identityMap or appId passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }
        if (MapUtils.isEmpty(listTransactionRequestsRequestVO.getRecipientMap()) || StringUtils.isEmpty(listTransactionRequestsRequestVO.getType())
                || StringUtils.isEmpty(listTransactionRequestsRequestVO.getAfterTxrId())
                || StringUtils.isEmpty(listTransactionRequestsRequestVO.getLimit())) {
            LOGGER.warning("recipientMap, type, afterTxrId or limit passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }
        if (StringUtils.isEmpty(listTransactionRequestsRequestVO.getCurrency())) {
            LOGGER.warning("currency passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", listTransactionRequestsRequestVO.getAuth().get());
        params.put("identity", listTransactionRequestsRequestVO.getIdentityMap().get());
        params.put("app_id", listTransactionRequestsRequestVO.getAppId().get());
        params.put("recipient", listTransactionRequestsRequestVO.getRecipientMap().get());
        params.put("type", listTransactionRequestsRequestVO.getType().get());
        params.put("after_txr_id", listTransactionRequestsRequestVO.getAfterTxrId().get());
        params.put("limit", listTransactionRequestsRequestVO.getLimit().get());
        params.put("currency", listTransactionRequestsRequestVO.getCurrency().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_LIST;

        listTransactionRequestsResponseVO = (ListTransactionRequestsResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), ListTransactionRequestsResponseVO[].class, method, params);
        return listTransactionRequestsResponseVO;
    }

    /**
     * Method to create an transactionRequest
     *
     * @param createTransactionRequestRequestVO - create the transactionRequest request vo
     * @return - CreateTransactionRequestResponseVO
     */
    public CreateTransactionRequestResponseVO createTransactionRequest(CreateTransactionRequestRequestVO createTransactionRequestRequestVO) {
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = null;

        if (ObjectUtils.isNull(createTransactionRequestRequestVO) || StringUtils.isEmpty(createTransactionRequestRequestVO.getAuth())
                || MapUtils.isEmpty(createTransactionRequestRequestVO.getIdentityMap())
                || MapUtils.isEmpty(createTransactionRequestRequestVO.getRecipientMap())) {
            LOGGER.warning("createTransactionRequestRequestVO is null, auth, identityMap or recipientMap passed in are null or empty");
            return createTransactionRequestResponseVO;
        }

        if (StringUtils.isEmpty(createTransactionRequestRequestVO.getType())
                || StringUtils.isEmpty(createTransactionRequestRequestVO.getIcon())
                || StringUtils.isEmpty(createTransactionRequestRequestVO.getTitle())
                || MapUtils.isEmpty(createTransactionRequestRequestVO.getValueMap())) {
            LOGGER.warning("type, icon, title or valueMap passed in are null or empty");
            return createTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", createTransactionRequestRequestVO.getAuth().get());
        params.put("identity", createTransactionRequestRequestVO.getIdentityMap().get());
        params.put("recipient", createTransactionRequestRequestVO.getRecipientMap().get());
        params.put("type", createTransactionRequestRequestVO.getType().get());
        params.put("icon", createTransactionRequestRequestVO.getIcon().get());
        params.put("title", createTransactionRequestRequestVO.getTitle().get());
        params.put("value", createTransactionRequestRequestVO.getValueMap().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CREATE;

        createTransactionRequestResponseVO = (CreateTransactionRequestResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), CreateTransactionRequestResponseVO.class, method, params);

        return createTransactionRequestResponseVO;
    }

    /**
     * Method to cancel an transactionRequest
     *
     * @param cancelTransactionRequestRequestVO - cancel the transactionRequest request vo
     * @return - CancelTransactionRequestResponseVO
     */
    public CancelTransactionRequestResponseVO cancelTransactionRequest(CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO) {
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = null;

        if (ObjectUtils.isNull(cancelTransactionRequestRequestVO) || StringUtils.isEmpty(cancelTransactionRequestRequestVO.getAuth())
                || StringUtils.isEmpty(cancelTransactionRequestRequestVO.getTxrId())) {
            LOGGER.warning("cancelTransactionRequestRequestVO is null or auth, txrId passed in are null or empty");
            return cancelTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", cancelTransactionRequestRequestVO.getAuth().get());
        params.put("txr_id", cancelTransactionRequestRequestVO.getTxrId().get());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CANCEL;

        Boolean result = (Boolean) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), Boolean.class, method, params);
        cancelTransactionRequestResponseVO = ImmutableCancelTransactionRequestResponseVO.builder()
                .setResult(result)
                .build();

        return cancelTransactionRequestResponseVO;
    }

}
