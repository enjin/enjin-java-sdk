package com.enjin.enjincoin.sdk.model.service.requests;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;
import com.enjin.enjincoin.sdk.model.service.requests.data.AddLogData;
import com.enjin.enjincoin.sdk.model.service.requests.data.AdvancedSendTokenData;
import com.enjin.enjincoin.sdk.model.service.requests.data.ApproveEnjData;
import com.enjin.enjincoin.sdk.model.service.requests.data.ApproveItemData;
import com.enjin.enjincoin.sdk.model.service.requests.data.BatchApproveData;
import com.enjin.enjincoin.sdk.model.service.requests.data.CompleteTradeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.CreateTokenData;
import com.enjin.enjincoin.sdk.model.service.requests.data.CreateTradeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.DecreaseMaxMeltFeeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.DecreaseMaxTransferFeeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.MeltTokenData;
import com.enjin.enjincoin.sdk.model.service.requests.data.MessageData;
import com.enjin.enjincoin.sdk.model.service.requests.data.MintTokenData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SendTokenData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetApprovalData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetApprovalForAllData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetItemUriData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetMeltFeeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetTransferFeeData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetTransferableData;
import com.enjin.enjincoin.sdk.model.service.requests.data.SetWhitelistedData;
import com.enjin.enjincoin.sdk.model.service.requests.data.UpdateItemNameData;

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

    public CreateRequest withCreateTokenData(CreateTokenData createTokenData) {
        withParameter("create_token_data", createTokenData);
        return this;
    }

    public CreateRequest withCreateTradeData(CreateTradeData createTradeData) {
        withParameter("create_trade_data", createTradeData);
        return this;
    }

    public CreateRequest withCompleteTradeData(CompleteTradeData completeTradeData) {
        withParameter("complete_trade_data", completeTradeData);
        return this;
    }

    public CreateRequest withMintTokenData(MintTokenData mintTokenData) {
        withParameter("mint_token_data", mintTokenData);
        return this;
    }

    public CreateRequest withMeltTokenData(MeltTokenData meltTokenData) {
        withParameter("melt_token_data", meltTokenData);
        return this;
    }

    public CreateRequest withSendTokenData(SendTokenData sendTokenData) {
        withParameter("send_token_data", sendTokenData);
        return this;
    }

    public CreateRequest withAdvancedSendTokenData(AdvancedSendTokenData advancedSendTokenData) {
        withParameter("advanced_send_token_data", advancedSendTokenData);
        return this;
    }

    public CreateRequest withUpdateItemNameData(UpdateItemNameData updateItemNameData) {
        withParameter("update_item_name_data", updateItemNameData);
        return this;
    }

    public CreateRequest withSetItemUriData(SetItemUriData setItemUriData) {
        withParameter("set_item_uri_data", setItemUriData);
        return this;
    }

    public CreateRequest withSetWhitelistedData(SetWhitelistedData setWhitelistedData) {
        withParameter("set_whitelisted_data", setWhitelistedData);
        return this;
    }

    public CreateRequest withApproveEnjData(ApproveEnjData approveEnjData) {
        withParameter("approve_enj_data", approveEnjData);
        return this;
    }

    public CreateRequest withApproveItemData(ApproveItemData approveItemData) {
        withParameter("approve_item_data", approveItemData);
        return this;
    }

    public CreateRequest withSetTransferableData(SetTransferableData setTransferableData) {
        withParameter("set_transferable_data", setTransferableData);
        return this;
    }

    public CreateRequest withSetMeltFeeData(SetMeltFeeData setMeltFeeData) {
        withParameter("set_melt_fee_data", setMeltFeeData);
        return this;
    }

    public CreateRequest withDecreaseMaxMeltFeeData(DecreaseMaxMeltFeeData decreaseMaxMeltFeeData) {
        withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
        return this;
    }

    public CreateRequest withSetTransferFeeData(SetTransferFeeData setTransferFeeData) {
        withParameter("set_transfer_fee_data", setTransferFeeData);
        return this;
    }

    public CreateRequest withDecreaseMaxTransferFeeData(DecreaseMaxTransferFeeData decreaseMaxTransferFeeData) {
        withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        return this;
    }

    public CreateRequest withAddLogData(AddLogData addLogData) {
        withParameter("add_log_data", addLogData);
        return this;
    }

    public CreateRequest withBatchApproveData(BatchApproveData batchApproveData) {
        withParameter("batch_approve_data", batchApproveData);
        return this;
    }

    public CreateRequest withSetApprovalData(SetApprovalData setApprovalData) {
        withParameter("set_approval_data", setApprovalData);
        return this;
    }

    public CreateRequest withSetApprovalForAllData(SetApprovalForAllData setApprovalForAllData) {
        withParameter("set_approval_for_all_data", setApprovalForAllData);
        return this;
    }

    public CreateRequest withMessageData(MessageData messageData) {
        withParameter("message_data", messageData);
        return this;
    }

}
