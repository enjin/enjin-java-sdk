package com.enjin.sdk.model.service.identities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.enjin.sdk.model.service.tokens.Token;
import com.enjin.sdk.service.identities.IdentitiesService;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform identity.
 *
 * @author Evan Lindsay
 * @see IdentitiesService
 */
@ToString
@Getter
public class Identity {

    /**
     * The identity id.
     *
     * @return the identity id.
     */
    private Integer id;

    /**
     * The app id.
     *
     * @return the app id.
     */
    @SerializedName("app_id")
    private Integer appId;

    /**
     * The linked ethereum address.
     *
     * @return the ethereum address.
     */
    @SerializedName("ethereum_address")
    private String ethereumAddress;

    /**
     * The linking code.
     *
     * @return the linking code.
     */
    @SerializedName("linking_code")
    private String linkingCode;

    /**
     * The linking code qr.
     *
     * @return the linking code qr.
     */
    @SerializedName("linking_code_qr")
    private String linkingCodeQr;

    /**
     * The owned tokens.
     *
     * @return a list of owned tokens.
     */
    private List<Token> tokens;

    /**
     * The eth balance.
     *
     * @return the eth balance.
     */
    @SerializedName("eth_balance")
    private BigDecimal ethBalance;

    /**
     * The enj balance.
     *
     * @return the enj balance.
     */
    @SerializedName("enj_balance")
    private BigDecimal enjBalance;

    /**
     * The set enj allowance.
     *
     * @return the set enj allowance.
     */
    @SerializedName("enj_allowance")
    private BigInteger enjAllowance;

    /**
     * The aggregated total and value in enj of owned tokens.
     *
     * @return the aggregated balance.
     */
    @SerializedName("all_tokens_balance")
    private AggregatedBalance allTokensBalance;

}
