package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.model.service.tokens.Token;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@ToString
@Getter
public class Identity {

    private BigInteger id;

    @SerializedName("app_id")
    private BigInteger appId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private String linkingCode;

    @SerializedName("linking_code_qr")
    private String linkingCodeQr;

    private List<IdentityField> fields;

    private List<Token> tokens;

    @SerializedName("eth_balance")
    private BigDecimal ethBalance;

    @SerializedName("enj_balance")
    private BigDecimal enjBalance;

    @SerializedName("enj_allowance")
    private BigDecimal enjAllowance;

    @SerializedName("all_tokens_balance")
    private JsonObject allTokensBalance;

}
