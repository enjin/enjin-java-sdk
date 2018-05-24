package com.enjin.enjincoin.sdk.client.service.identities.vo;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;
import com.enjin.enjincoin.sdk.client.service.platform.vo.AppDetail;

/**
 * <p>Get Identity Response class.
 * </p>
 */
public class Identity {


    @SerializedName("id")
    private Integer id;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private String linkingCode;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("users")
    private String user;

    @SerializedName("fields")
    private IdentityField[] fields;

    @SerializedName("app")
    private AppDetail app;

    @SerializedName("tokens")
    private TokenEntry[] tokens;

    public Identity(Integer id, String ethereumAddress, String linkingCode, String updatedAt, String createdAt, String user,
                    IdentityField[] fields, AppDetail app, TokenEntry[] tokens) {
        super();
        this.id = id;
        this.ethereumAddress = ethereumAddress;
        this.linkingCode = linkingCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.user = user;
        this.fields = fields;
        this.app = app;
        this.tokens = tokens;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the ethereumAddress
     */
    public String getEthereumAddress() {
        return this.ethereumAddress;
    }

    /**
     * @return the linkingCode
     */
    public String getLinkingCode() {
        return this.linkingCode;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * @return the users
     */
    public String getUser() {
        return this.user;
    }

    /**
     * @return the fields
     */
    public IdentityField[] getFields() {
        return this.fields;
    }

    /**
     * @return the app
     */
    public AppDetail getApp() {
        return this.app;
    }

    /**
     * @return the tokens
     */
    public TokenEntry[] getTokens() {
        return this.tokens;
    }

    /**
     * set the tokens
     * @param tokens the tokens
     */
    public void setTokens(TokenEntry[] tokens) {
        this.tokens = tokens;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Identity [id=" + this.id + ", ethereumAddress=" + this.ethereumAddress + ", linkingCode=" + this.linkingCode + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + ", users=" + this.user
                + ", fields=" + Arrays.toString(this.fields) + "]";
    }
}
