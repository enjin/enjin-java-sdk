package com.enjin.enjincoin.sdk.service.identities.vo;

import com.enjin.enjincoin.sdk.service.tokens.vo.Token;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Identity {

    private Integer id;

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private String linkingCode;

    @SerializedName("linking_code_qr")
    private String linkingCodeQr;

    private List<IdentityField> fields;

    private List<Token> tokens;

    @SerializedName("eth_balance")
    private Double ethBalance;

    @SerializedName("enj_balance")
    private Double enjBalance;

    @SerializedName("enj_allowance")
    private Double enjAllowance;

    @SerializedName("all_tokens_balance")
    private JsonObject allTokensBalance;

    public Integer getId() {
        return this.id;
    }

    public Integer getAppId() {
        return this.appId;
    }

    public String getEthereumAddress() {
        return this.ethereumAddress;
    }

    public String getLinkingCode() {
        return this.linkingCode;
    }

    public String getLinkingCodeQr() {
        return linkingCodeQr;
    }

    public List<IdentityField> getFields() {
        return this.fields;
    }

    public List<Token> getTokens() { return this.tokens; }

    public Double getEthBalance() {
        return this.ethBalance;
    }

    public Double getEnjBalance() {
        return this.enjBalance;
    }

    public Double getEnjAllowance() {
        return enjAllowance;
    }

    public JsonObject getAllTokensBalance() {
        return this.allTokensBalance;
    }
}
