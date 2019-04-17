package com.enjin.enjincoin.sdk.model.service.requests;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.google.gson.JsonObject;

public class UpdateRequest extends GraphQLRequest.Builder {

    public UpdateRequest withIdentityId(int identityId) {
        withParameter("identity_id", identityId);
        return this;
    }

    public UpdateRequest withType(TransactionType type) {
        withParameter("type", type);
        return this;
    }

    public UpdateRequest withRebroadcast(RebroadcastType rebroadcast) {
        withParameter("rebroadcast", rebroadcast);
        return this;
    }

    public UpdateRequest withCreateTokenData(JsonObject createTokenData) {
        withParameter("create_token_data", createTokenData);
        return this;
    }

    public UpdateRequest withCreateTradeData(JsonObject createTradeData) {
        withParameter("create_trade_data", createTradeData);
        return this;
    }

    public UpdateRequest withCompleteTradeData(JsonObject completeTradeData) {
        withParameter("complete_trade_data", completeTradeData);
        return this;
    }

    public UpdateRequest withMintTokenData(JsonObject mintTokenData) {
        withParameter("mint_token_data", mintTokenData);
        return this;
    }

    public UpdateRequest withMeltTokenData(JsonObject meltTokenData) {
        withParameter("melt_token_data", meltTokenData);
        return this;
    }

    public UpdateRequest withSendTokenData(JsonObject sendTokenData) {
        withParameter("send_token_data", sendTokenData);
        return this;
    }

    public UpdateRequest withAdvancedSendTokenData(JsonObject advancedSendTokenData) {
        withParameter("advanced_send_token_data", advancedSendTokenData);
        return this;
    }

    public UpdateRequest withUpdateItemNameData(JsonObject updateItemNameData) {
        withParameter("update_item_name_data", updateItemNameData);
        return this;
    }

    public UpdateRequest withSetItemUriData(JsonObject setItemUriData) {
        withParameter("set_item_uri_data", setItemUriData);
        return this;
    }

    public UpdateRequest withSetWhitelistedData(JsonObject setWhitelistedData) {
        withParameter("set_whitelisted_data", setWhitelistedData);
        return this;
    }

    public UpdateRequest withApproveEnjData(JsonObject approveEnjData) {
        withParameter("approve_enj_data", approveEnjData);
        return this;
    }

    public UpdateRequest withApproveItemData(JsonObject approveItemData) {
        withParameter("approve_item_data", approveItemData);
        return this;
    }

    public UpdateRequest withSetTransferableData(JsonObject setTransferableData) {
        withParameter("set_transferable_data", setTransferableData);
        return this;
    }

    public UpdateRequest withSetMeltFeeData(JsonObject setMeltFeeData) {
        withParameter("set_melt_fee_data", setMeltFeeData);
        return this;
    }

    public UpdateRequest withDecreaseMaxMeltFeeData(JsonObject decreaseMaxMeltFeeData) {
        withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
        return this;
    }

    public UpdateRequest withSetTransferFeeData(JsonObject setTransferFeeData) {
        withParameter("set_transfer_fee_data", setTransferFeeData);
        return this;
    }

    public UpdateRequest withDecreaseMaxTransferFeeData(JsonObject decreaseMaxTransferFeeData) {
        withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        return this;
    }

    public UpdateRequest withAddLogData(JsonObject addLogData) {
        withParameter("add_log_data", addLogData);
        return this;
    }

    public UpdateRequest withBatchApproveData(JsonObject batchApproveData) {
        withParameter("batch_approve_data", batchApproveData);
        return this;
    }

    public UpdateRequest withSetApprovalData(JsonObject setApprovalData) {
        withParameter("set_approval_data", setApprovalData);
        return this;
    }

    public UpdateRequest withSetApprovalForAllData(JsonObject setApprovalForAllData) {
        withParameter("set_approval_for_all_data", setApprovalForAllData);
        return this;
    }

    public UpdateRequest withMessageData(JsonObject messageData) {
        withParameter("message_data", messageData);
        return this;
    }

}
