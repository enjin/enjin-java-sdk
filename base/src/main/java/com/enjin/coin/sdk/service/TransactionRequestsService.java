package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ValidationUtils;
import com.enjin.coin.sdk.vo.transactionrequest.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TransactionRequestsService extends BaseService {

    private static final Logger LOGGER = Logger.getLogger(TransactionRequestsService.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig
     */
    protected TransactionRequestsService(EnjinConfig enjinConfig) {
        super(enjinConfig);
    }

    /**
     * Method to get an transactionRequest
     *
     * @param getTransactionRequestRequestVO
     * @return
     */
    public GetTransactionRequestResponseVO getTransactionRequest(GetTransactionRequestRequestVO getTransactionRequestRequestVO) {
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = null;

        if (getTransactionRequestRequestVO == null || ValidationUtils.isEmpty(getTransactionRequestRequestVO.getAuth()) || ValidationUtils.isEmpty(getTransactionRequestRequestVO.getTxrId())) {
            LOGGER.warning("getTransactionRequestRequestVO is null, auth or identidyId passed in are null or empty");
            return getTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", getTransactionRequestRequestVO.getAuth());
        params.put("txr_id", getTransactionRequestRequestVO.getTxrId());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_GET;

        getTransactionRequestResponseVO = (GetTransactionRequestResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), GetTransactionRequestResponseVO.class, method, params);

        return getTransactionRequestResponseVO;
    }

    /**
     * Method to list the transactionRequests
     *
     * @param listTransactionRequestsRequestVO
     * @return
     */
    public ListTransactionRequestsResponseVO[] listTransactionRequests(ListTransactionRequestsRequestVO listTransactionRequestsRequestVO) {
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVO = null;

        if (listTransactionRequestsRequestVO == null || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getAuth()) || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getIdentityMap()) || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getAppId())) {
            LOGGER.warning("listTransactionRequestsRequestVO is null, auth, identityMap or appId passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }
        if (ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getRecipientMap()) || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getType()) || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getAfterTxrId()) || ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getLimit())) {
            LOGGER.warning("recipientMap, type, afterTxrId or limit passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }
        if (ValidationUtils.isEmpty(listTransactionRequestsRequestVO.getCurrency())) {
            LOGGER.warning("currency passed in are null or empty");
            return listTransactionRequestsResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", listTransactionRequestsRequestVO.getAuth());
        params.put("identity", listTransactionRequestsRequestVO.getIdentityMap());
        params.put("app_id", listTransactionRequestsRequestVO.getAppId());
        params.put("recipient", listTransactionRequestsRequestVO.getRecipientMap());
        params.put("type", listTransactionRequestsRequestVO.getType());
        params.put("after_txr_id", listTransactionRequestsRequestVO.getAfterTxrId());
        params.put("limit", listTransactionRequestsRequestVO.getLimit());
        params.put("currency", listTransactionRequestsRequestVO.getCurrency());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_LIST;

        listTransactionRequestsResponseVO = (ListTransactionRequestsResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), ListTransactionRequestsResponseVO[].class, method, params);
        return listTransactionRequestsResponseVO;
    }

    /**
     * Method to create an transactionRequest
     *
     * @param createTransactionRequestRequestVO
     * @return
     */
    public CreateTransactionRequestResponseVO createTransactionRequest(CreateTransactionRequestRequestVO createTransactionRequestRequestVO) {
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = null;

        if (createTransactionRequestRequestVO == null || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getAuth()) || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getIdentityMap()) || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getRecipientMap())) {
            LOGGER.warning("createTransactionRequestRequestVO is null, auth, identityMap or recipientMap passed in are null or empty");
            return createTransactionRequestResponseVO;
        }
        if (ValidationUtils.isEmpty(createTransactionRequestRequestVO.getType()) || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getIcon()) || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getTitle()) || ValidationUtils.isEmpty(createTransactionRequestRequestVO.getValueMap())) {
            LOGGER.warning("type, icon, title or valueMap passed in are null or empty");
            return createTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", createTransactionRequestRequestVO.getAuth());
        params.put("identity", createTransactionRequestRequestVO.getIdentityMap());
        params.put("recipient", createTransactionRequestRequestVO.getRecipientMap());
        params.put("type", createTransactionRequestRequestVO.getType());
        params.put("icon", createTransactionRequestRequestVO.getIcon());
        params.put("title", createTransactionRequestRequestVO.getTitle());
        params.put("value", createTransactionRequestRequestVO.getValueMap());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CREATE;

        createTransactionRequestResponseVO = (CreateTransactionRequestResponseVO) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), CreateTransactionRequestResponseVO.class, method, params);

        return createTransactionRequestResponseVO;
    }

    /**
     * Method to cancel an transactionRequest
     *
     * @param cancelTransactionRequestRequestVO
     * @return
     */
    public CancelTransactionRequestResponseVO cancelTransactionRequest(CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO) {
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = null;

        if (cancelTransactionRequestRequestVO == null || ValidationUtils.isEmpty(cancelTransactionRequestRequestVO.getAuth()) || ValidationUtils.isEmpty(cancelTransactionRequestRequestVO.getTxrId())) {
            LOGGER.warning("cancelTransactionRequestRequestVO is null or auth, txrId passed in are null or empty");
            return cancelTransactionRequestResponseVO;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("auth", cancelTransactionRequestRequestVO.getAuth());
        params.put("txr_id", cancelTransactionRequestRequestVO.getTxrId());

        // Construct new request
        String method = Constants.METHOD_TRANSACTION_REQUESTS_CANCEL;

        Boolean result = (Boolean) jsonRpcUtils.sendJsonRpcRequest(getTransactionRequestsUrl(), Boolean.class, method, params);
        cancelTransactionRequestResponseVO = ImmutableCancelTransactionRequestResponseVO.builder()
                .setResult(result)
                .build();

        return cancelTransactionRequestResponseVO;
    }

}
