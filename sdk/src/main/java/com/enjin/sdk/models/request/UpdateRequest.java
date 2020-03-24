package com.enjin.sdk.models.request;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.models.request.data.AddLogData;
import com.enjin.sdk.models.request.data.AdvancedSendTokenData;
import com.enjin.sdk.models.request.data.ApproveEnjData;
import com.enjin.sdk.models.request.data.ApproveItemData;
import com.enjin.sdk.models.request.data.CompleteTradeData;
import com.enjin.sdk.models.request.data.CreateTokenData;
import com.enjin.sdk.models.request.data.CreateTradeData;
import com.enjin.sdk.models.request.data.DecreaseMaxMeltFeeData;
import com.enjin.sdk.models.request.data.DecreaseMaxTransferFeeData;
import com.enjin.sdk.models.request.data.MeltTokenData;
import com.enjin.sdk.models.request.data.MessageData;
import com.enjin.sdk.models.request.data.MintTokenData;
import com.enjin.sdk.models.request.data.ReleaseReserveData;
import com.enjin.sdk.models.request.data.SendEnjData;
import com.enjin.sdk.models.request.data.SendTokenData;
import com.enjin.sdk.models.request.data.SetApprovalForAllData;
import com.enjin.sdk.models.request.data.SetItemUriData;
import com.enjin.sdk.models.request.data.SetMeltFeeData;
import com.enjin.sdk.models.request.data.SetTransferFeeData;
import com.enjin.sdk.models.request.data.SetTransferableData;
import com.enjin.sdk.models.request.data.SetWhitelistedData;
import com.enjin.sdk.models.request.data.UpdateItemNameData;
import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for updating a request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class UpdateRequest extends GraphQLRequest<UpdateRequest> implements TransactionFragment<UpdateRequest> {

    private UpdateRequest id(Integer id) {
        set("id", id);
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
        set("rebroadcast", rebroadcast);
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
        set("create_token_data", createTokenData);
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
        set("create_trade_data", createTradeData);
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
        set("complete_trade_data", completeTradeData);
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
        set("mint_token_data", mintTokenData);
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
        set("melt_token_data", meltTokenData);
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
        set("send_token_data", sendTokenData);
        return this;
    }

    public UpdateRequest sendEnj(SendEnjData sendEnjData) {
        set("send_enj_data", sendEnjData);
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
        set("advanced_send_token_data", advancedSendTokenData);
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
        set("update_item_name_data", updateItemNameData);
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
        set("set_item_uri_data", setItemUriData);
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
        set("set_whitelisted_data", setWhitelistedData);
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
        set("approve_enj_data", approveEnjData);
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
        set("approve_item_data", approveItemData);
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
        set("set_transferable_data", setTransferableData);
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
        set("set_melt_fee_data", setMeltFeeData);
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
        set("decrease_max_melt_fee_data", decreaseMaxMeltFeeData);
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
        set("set_transfer_fee_data", setTransferFeeData);
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
        set("decrease_max_transfer_fee_data", decreaseMaxTransferFeeData);
        return this;
    }

    public UpdateRequest releaseReserve(ReleaseReserveData releaseReserveData) {
        set("release_reserve_data", releaseReserveData);
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
        set("add_log_data", addLogData);
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
        set("set_approval_for_all_data", setApprovalForAllData);
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
        set("message_data", messageData);
        return this;
    }

}
