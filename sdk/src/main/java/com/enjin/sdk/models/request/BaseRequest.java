package com.enjin.sdk.models.request;

import com.enjin.sdk.graphql.GraphQLRequest;
import static com.enjin.sdk.models.request.TransactionType.*;
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
 * A builder for creating a new request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class BaseRequest<T extends BaseRequest<T>> extends GraphQLRequest<T> implements TransactionFragment<T> {

    private final boolean setType;

    public BaseRequest(boolean setType) {
        this.setType = setType;
    }

    /**
     * The transaction type.
     *
     * @param type the transaction type.
     *
     * @return the builder.
     */
    public T set(String key, Object val, TransactionType type) {
        if (setType)
            set("txType", type);
        set(key, val);
        return (T) this;
    }

    /**
     * Sets the create token data.
     *
     * @param createTokenData the data.
     *
     * @return the builder.
     */
    public T createToken(CreateTokenData createTokenData) {
        return set("createTokenData", createTokenData, CREATE);
    }

    /**
     * Sets the create trade data.
     *
     * @param createTradeData the data.
     *
     * @return the builder.
     */
    public T createTrade(CreateTradeData createTradeData) {
        return set("createTradeData", createTradeData, CREATE_TRADE);
    }

    /**
     * Sets the complete trade data.
     *
     * @param completeTradeData the data.
     *
     * @return the builder.
     */
    public T completeTrade(CompleteTradeData completeTradeData) {
        return set("completeTradeData", completeTradeData, COMPLETE_TRADE);
    }

    /**
     * Sets the mint data.
     *
     * @param mintTokenData the data.
     *
     * @return the builder.
     */
    public T mintToken(MintTokenData mintTokenData) {
        return set("mintTokenData", mintTokenData, MINT);
    }

    /**
     * Sets the melt data.
     *
     * @param meltTokenData the data.
     *
     * @return the builder.
     */
    public T meltToken(MeltTokenData meltTokenData) {
        return set("meltTokenData", meltTokenData, MELT);
    }

    /**
     * Sets the send token data.
     *
     * @param sendTokenData the data.
     *
     * @return the builder.
     */
    public T sendToken(SendTokenData sendTokenData) {
        return set("sendTokenData", sendTokenData, SEND);
    }

    public T sendEnj(SendEnjData sendEnjData) {
        return set("sendEnjData", sendEnjData, SEND_ENJ);
    }

    /**
     * Sets the advanced send token data.
     *
     * @param advancedSendTokenData the data.
     *
     * @return the builder.
     */
    public T advancedSendToken(AdvancedSendTokenData advancedSendTokenData) {
        return set("advancedSendTokenData", advancedSendTokenData, ADVANCED_SEND);
    }

    /**
     * Sets the update item name data.
     *
     * @param updateItemNameData the data.
     *
     * @return the builder.
     */
    public T updateItemName(UpdateItemNameData updateItemNameData) {
        return set("updateItemNameData", updateItemNameData, UPDATE_NAME);
    }

    /**
     * Sets the set item uri data.
     *
     * @param setItemUriData the data.
     *
     * @return the builder.
     */
    public T setItemUri(SetItemUriData setItemUriData) {
        return set("setItemUriData", setItemUriData, SET_ITEM_URI);
    }

    /**
     * Sets the set whitelisted data.
     *
     * @param setWhitelistedData the data.
     *
     * @return the builder.
     */
    public T setWhitelisted(SetWhitelistedData setWhitelistedData) {
        return set("setWhitelistedData", setWhitelistedData, SET_WHITELISTED);
    }

    /**
     * Sets the approve enj data.
     *
     * @param approveEnjData the data.
     *
     * @return the builder.
     */
    public T approveEnj(ApproveEnjData approveEnjData) {
        return set("approveEnjData", approveEnjData, APPROVE);
    }

    /**
     * Sets the approve item data.
     *
     * @param approveItemData the data.
     *
     * @return the builder.
     */
    public T approveItem(ApproveItemData approveItemData) {
        return set("approveItemData", approveItemData, APPROVE);
    }

    /**
     * Sets the set transferable data.
     *
     * @param setTransferableData the data.
     *
     * @return the builder.
     */
    public T setTransferable(SetTransferableData setTransferableData) {
        return set("setTransferableData", setTransferableData, SET_TRANSFERABLE);
    }

    /**
     * Sets the set melt fee data.
     *
     * @param setMeltFeeData the data.
     *
     * @return the builder.
     */
    public T setMeltFee(SetMeltFeeData setMeltFeeData) {
        return set("setMeltFeeData", setMeltFeeData, SET_MELT_FEE);
    }

    /**
     * Sets the decrease max melt fee data.
     *
     * @param decreaseMaxMeltFeeData the data.
     *
     * @return the builder.
     */
    public T decreaseMaxMeltFee(DecreaseMaxMeltFeeData decreaseMaxMeltFeeData) {
        return set("decreaseMaxMeltFeeData", decreaseMaxMeltFeeData, DECREASE_MAX_MELT_FEE);
    }

    /**
     * Sets the set transfer fee data.
     *
     * @param setTransferFeeData the data.
     *
     * @return the builder.
     */
    public T setTransferFee(SetTransferFeeData setTransferFeeData) {
        return set("setTransferFeeData", setTransferFeeData, SET_TRANSFER_FEE);
    }

    /**
     * Sets the decrease max transfer fee data.
     *
     * @param decreaseMaxTransferFeeData the data.
     *
     * @return the builder.
     */
    public T decreaseMaxTransferFee(DecreaseMaxTransferFeeData decreaseMaxTransferFeeData) {
        return set("decreaseMaxTransferFeeData", decreaseMaxTransferFeeData, DECREASE_MAX_TRANSFER_FEE);
    }

    public T releaseReserve(ReleaseReserveData releaseReserveData) {
        return set("releaseReserveData", releaseReserveData, RELEASE_RESERVE);
    }

    /**
     * Sets the add log data.
     *
     * @param addLogData the data.
     *
     * @return the builder.
     */
    public T addLog(AddLogData addLogData) {
        return set("addLogData", addLogData, ADD_LOG);
    }

    /**
     * Sets the set approval for all data.
     *
     * @param setApprovalForAllData the data.
     *
     * @return the builder.
     */
    public T setApprovalForAll(SetApprovalForAllData setApprovalForAllData) {
        return set("setApprovalForAllData", setApprovalForAllData, SET_APPROVAL_FOR_ALL);
    }

    /**
     * Sets the message data.
     *
     * @param messageData the data.
     *
     * @return the builder.
     */
    public T message(MessageData messageData) {
        return set("messageDate", messageData, MESSAGE);
    }

}
