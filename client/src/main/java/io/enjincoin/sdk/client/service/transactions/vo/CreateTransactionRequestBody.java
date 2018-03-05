package io.enjincoin.sdk.client.service.transactions.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Transaction Response class.</p>
 */
public class CreateTransactionRequestBody {

    @SerializedName("identity_id")
    private Optional<Integer> identityId;

    @SerializedName("token_id")
    private Optional<Integer> tokenId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("value")
    private Optional<String> value;

    @SerializedName("recipient_id")
    private Optional<Integer> recipientId;


    /**
     * Class constructor.
     * @param identityId
     * @param tokenId
     * @param appId
     * @param value
     * @param recipientId
     */
    public CreateTransactionRequestBody(Integer identityId, Integer tokenId, Integer appId, String value, Integer recipientId) {
        super();
        this.identityId = Optional.of(identityId);
        this.tokenId = Optional.of(tokenId);
        this.appId = Optional.of(appId);
        this.value = Optional.of(value);
        this.recipientId = Optional.of(recipientId);
    }

    /**
     * @return the identityId
     */
    public Optional<Integer> getIdentityId() {
        return identityId;
    }

    /**
     * @return the tokenId
     */
    public Optional<Integer> getTokenId() {
        return tokenId;
    }

    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
    }

    /**
     * @return the value
     */
    public Optional<String> getValue() {
        return value;
    }

    /**
     * @return the recipientId
     */
    public Optional<Integer> getRecipientId() {
        return recipientId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateTransactionRequestBody [identityId=" + identityId + ", tokenId=" + tokenId + ", appId=" + appId + ", value=" + value + ", recipientId=" + recipientId + "]";
    }
}

