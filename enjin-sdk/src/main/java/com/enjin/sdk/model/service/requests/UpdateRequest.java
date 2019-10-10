package com.enjin.sdk.model.service.requests;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.model.service.requests.data.AddLogData;
import com.enjin.sdk.model.service.requests.data.AdvancedSendTokenData;
import com.enjin.sdk.model.service.requests.data.ApproveEnjData;
import com.enjin.sdk.model.service.requests.data.ApproveItemData;
import com.enjin.sdk.model.service.requests.data.CompleteTradeData;
import com.enjin.sdk.model.service.requests.data.CreateTokenData;
import com.enjin.sdk.model.service.requests.data.CreateTradeData;
import com.enjin.sdk.model.service.requests.data.DecreaseMaxMeltFeeData;
import com.enjin.sdk.model.service.requests.data.DecreaseMaxTransferFeeData;
import com.enjin.sdk.model.service.requests.data.MeltTokenData;
import com.enjin.sdk.model.service.requests.data.MessageData;
import com.enjin.sdk.model.service.requests.data.MintTokenData;
import com.enjin.sdk.model.service.requests.data.SendTokenData;
import com.enjin.sdk.model.service.requests.data.SetApprovalForAllData;
import com.enjin.sdk.model.service.requests.data.SetItemUriData;
import com.enjin.sdk.model.service.requests.data.SetMeltFeeData;
import com.enjin.sdk.model.service.requests.data.SetTransferFeeData;
import com.enjin.sdk.model.service.requests.data.SetTransferableData;
import com.enjin.sdk.model.service.requests.data.SetWhitelistedData;
import com.enjin.sdk.model.service.requests.data.UpdateItemNameData;
import com.enjin.sdk.service.requests.RequestsService;

/**
 * A builder for updating a request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class UpdateRequest extends GraphQLRequest<UpdateRequest> {

    /**
     * The id of the identity this request was created for.
     *
     * @param identityId the identity id.
     *
     * @return builder.
     */
    public UpdateRequest identityId(int identityId) {
        withParameter("identity_id", identityId);
        return this;
    }

    /**
     * The transaction type.
     *
     * @param type the transaction type.
     *
     * @return the builder.
     */
    public UpdateRequest transactionType(TransactionType type) {
        withParameter("type", type);
        return this;
    }

    /**
     * Can be set to retry or cancel a transaction.
     *
     * @param rebroadcast the rebroadcast type.
     *
     * @return the builder.
     */
    public UpdateRequest rebroadcast(RebroadcastType rebroadcast) {
        withParameter("rebroadcast", rebroadcast);
        return this;
    }

    /**
     * Sets the create token data.
     *
     * @param createTokenData the data.
     *
     * @return the builder.
     */
    public UpdateRequest createToken(CreateTokenData createTokenData) {
        withParameter("create_token_data", createTokenData);
        transactionType(TransactionType.CREATE);
        return this;
    }

    /**
     * Sets the create trade data.
     *
     * @param createTradeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest createTrade(CreateTradeData createTradeData) {
        withParameter("create_trade_data", createTradeData);
        transactionType(TransactionType.CREATE_TRADE);
        return this;
    }

    /**
     * Sets the complete trade data.
     *
     * @param completeTradeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest completeTrade(CompleteTradeData completeTradeData) {
        withParameter("complete_trade_data", completeTradeData);
        transactionType(TransactionType.COMPLETE_TRADE);
        return this;
    }

    /**
     * Sets the mint data.
     *
     * @param mintTokenData the data.
     *
     * @return the builder.
     */
    public UpdateRequest mintToken(MintTokenData mintTokenData) {
        withParameter("mint_token_data", mintTokenData);
        transactionType(TransactionType.MINT);
        return this;
    }

    /**
     * Sets the melt data.
     *
     * @param meltTokenData the data.
     *
     * @return the builder.
     */
    public UpdateRequest meltToken(MeltTokenData meltTokenData) {
        withParameter("melt_token_data", meltTokenData);
        transactionType(TransactionType.MELT);
        return this;
    }

    /**
     * Sets the send token data.
     *
     * @param sendTokenData the data.
     *
     * @return the builder.
     */
    public UpdateRequest sendToken(SendTokenData sendTokenData) {
        withParameter("send_token_data", sendTokenData);
        transactionType(TransactionType.SEND);
        return this;
    }

    /**
     * Sets the advanced send token data.
     *
     * @param advancedSendTokenData the data.
     *
     * @return the builder.
     */
    public UpdateRequest advancedSendToken(AdvancedSendTokenData advancedSendTokenData) {
        withParameter("advanced_send_token_data", advancedSendTokenData);
        transactionType(TransactionType.ADVANCED_SEND);
        return this;
    }

    /**
     * Sets the update item name data.
     *
     * @param updateItemNameData the data.
     *
     * @return the builder.
     */
    public UpdateRequest updateItemName(UpdateItemNameData updateItemNameData) {
        withParameter("update_item_name_data", updateItemNameData);
        transactionType(TransactionType.UPDATE_NAME);
        return this;
    }

    /**
     * Sets the set item uri data.
     *
     * @param setItemUriData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setItemUri(SetItemUriData setItemUriData) {
        withParameter("set_item_uri_data", setItemUriData);
        transactionType(TransactionType.SET_ITEM_URI);
        return this;
    }

    /**
     * Sets the set whitelisted data.
     *
     * @param setWhitelistedData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setWhitelisted(SetWhitelistedData setWhitelistedData) {
        withParameter("set_whitelisted_data", setWhitelistedData);
        transactionType(TransactionType.SET_WHITELISTED);
        return this;
    }

    /**
     * Sets the approve enj data.
     *
     * @param approveEnjData the data.
     *
     * @return the builder.
     */
    public UpdateRequest approveEnj(ApproveEnjData approveEnjData) {
        withParameter("approve_enj_data", approveEnjData);
        transactionType(TransactionType.APPROVE);
        return this;
    }

    /**
     * Sets the approve item data.
     *
     * @param approveItemData the data.
     *
     * @return the builder.
     */
    public UpdateRequest approveItem(ApproveItemData approveItemData) {
        withParameter("approve_item_data", approveItemData);
        transactionType(TransactionType.APPROVE);
        return this;
    }

    /**
     * Sets the set transferable data.
     *
     * @param setTransferableData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setTransferable(SetTransferableData setTransferableData) {
        withParameter("set_transferable_data", setTransferableData);
        transactionType(TransactionType.SET_TRANSFERABLE);
        return this;
    }

    /**
     * Sets the set melt fee data.
     *
     * @param setMeltFeeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setMeltFee(SetMeltFeeData setMeltFeeData) {
        withParameter("set_melt_fee_data", setMeltFeeData);
        transactionType(TransactionType.SET_MELT_FEE);
        return this;
    }

    /**
     * Sets the decrease max melt fee data.
     *
     * @param decreaseMaxMeltFeeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest decreaseMaxMeltFee(DecreaseMaxMeltFeeData decreaseMaxMeltFeeData) {
        withParameter("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
        transactionType(TransactionType.DECREASE_MAX_MELT_FEE);
        return this;
    }

    /**
     * Sets the set transfer fee data.
     *
     * @param setTransferFeeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setTransferFee(SetTransferFeeData setTransferFeeData) {
        withParameter("set_transfer_fee_data", setTransferFeeData);
        transactionType(TransactionType.SET_TRANSFER_FEE);
        return this;
    }

    /**
     * Sets the decrease max transfer fee data.
     *
     * @param decreaseMaxTransferFeeData the data.
     *
     * @return the builder.
     */
    public UpdateRequest decreaseMaxTransferFee(DecreaseMaxTransferFeeData decreaseMaxTransferFeeData) {
        withParameter("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        transactionType(TransactionType.DECREASE_MAX_TRANSFER_FEE);
        return this;
    }

    /**
     * Sets the add log data.
     *
     * @param addLogData the data.
     *
     * @return the builder.
     */
    public UpdateRequest addLog(AddLogData addLogData) {
        withParameter("add_log_data", addLogData);
        transactionType(TransactionType.ADD_LOG);
        return this;
    }

    /**
     * Sets the set approval for all data.
     *
     * @param setApprovalForAllData the data.
     *
     * @return the builder.
     */
    public UpdateRequest setApprovalForAll(SetApprovalForAllData setApprovalForAllData) {
        withParameter("set_approval_for_all_data", setApprovalForAllData);
        transactionType(TransactionType.SET_APPROVAL_FOR_ALL);
        return this;
    }

    /**
     * Sets the message data.
     *
     * @param messageData the data.
     *
     * @return the builder.
     */
    public UpdateRequest message(MessageData messageData) {
        withParameter("message_data", messageData);
        transactionType(TransactionType.MESSAGE);
        return this;
    }

}
