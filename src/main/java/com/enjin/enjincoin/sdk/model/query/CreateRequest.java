package com.enjin.enjincoin.sdk.model.query;

import com.enjin.enjincoin.sdk.model.request.GraphQLRequest;
import com.enjin.enjincoin.sdk.service.requests.vo.TransactionType;
import com.google.gson.JsonObject;

public class CreateRequest extends GraphQLRequest.Builder {

    public CreateRequest withIdentityId(int identityId) {
        withParameter("identity_id", identityId);
        return this;
    }

    public CreateRequest withType(TransactionType type) {
        withParameter("type", type);
        return this;
    }

    public CreateRequest withTest(boolean test) {
        withParameter("test", test);
        return this;
    }

    public CreateRequest withDummy(boolean dummy) {
        withParameter("dummy", dummy);
        return this;
    }

    public CreateRequest withCreateTokenData(JsonObject createTokenData) {
        withParameter("create_token_data", createTokenData);
        return this;
    }

    public CreateRequest withCreateTradeData(JsonObject createTradeData) {
        withParameter("create_trade_data", createTradeData);
        return this;
    }

    public CreateRequest withCompleteTradeData(JsonObject completeTradeData) {
        withParameter("complete_trade_data", completeTradeData);
        return this;
    }

    public CreateRequest withMintTokenData(JsonObject mintTokenData) {
        withParameter("mint_token_data", mintTokenData);
        return this;
    }

    public CreateRequest withMeltTokenData(JsonObject meltTokenData) {
        withParameter("melt_token_data", meltTokenData);
        return this;
    }

    public CreateRequest withSendTokenData(JsonObject sendTokenData) {
        withParameter("send_token_data", sendTokenData);
        return this;
    }

    public CreateRequest withAdvancedSendTokenData(JsonObject advancedSendTokenData) {
        withParameter("advanced_send_token_data", advancedSendTokenData);
        return this;
    }

    public CreateRequest withUpdateItemNameData(JsonObject updateItemNameData) {
        withParameter("update_item_name_data", updateItemNameData);
        return this;
    }

    public CreateRequest withSetItemUriData(JsonObject setItemUriData) {
        withParameter("set_item_uri_data", setItemUriData);
        return this;
    }

    public CreateRequest withSetWhitelistedData(JsonObject setWhitelistedData) {
        withParameter("set_whitelisted_data", setWhitelistedData);
        return this;
    }

    public CreateRequest withApproveEnjData(JsonObject approveEnjData) {
        withParameter("approve_enj_data", approveEnjData);
        return this;
    }

    public CreateRequest withApproveItemData(JsonObject approveItemData) {
        withParameter("approve_item_data", approveItemData);
        return this;
    }

    public CreateRequest withSetTransferableData(JsonObject setTransferableData) {
        withParameter("set_transferable_data", setTransferableData);
        return this;
    }

    public CreateRequest withSetMeltFeeData(JsonObject setMeltFeeData) {
        withParameter("set_melt_fee_data", setMeltFeeData);
        return this;
    }

    public CreateRequest withDecreaseMaxMeltFeeData(JsonObject decreaseMaxMeltFeeData) {
        withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
        return this;
    }

    public CreateRequest withSetTransferFeeData(JsonObject setTransferFeeData) {
        withParameter("set_transfer_fee_data", setTransferFeeData);
        return this;
    }

    public CreateRequest withDecreaseMaxTransferFeeData(JsonObject decreaseMaxTransferFeeData) {
        withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        return this;
    }

    public CreateRequest withAddLogData(JsonObject addLogData) {
        withParameter("add_log_data", addLogData);
        return this;
    }

    public CreateRequest withBatchApproveData(JsonObject batchApproveData) {
        withParameter("batch_approve_data", batchApproveData);
        return this;
    }

    public CreateRequest withSetApprovalData(JsonObject setApprovalData) {
        withParameter("set_approval_data", setApprovalData);
        return this;
    }

    public CreateRequest withSetApprovalForAllData(JsonObject setApprovalForAllData) {
        withParameter("set_approval_for_all_data", setApprovalForAllData);
        return this;
    }

    public CreateRequest withMessageData(JsonObject messageData) {
        withParameter("message_data", messageData);
        return this;
    }

}
