package com.enjin.sdk.model.service.requests.data;

import com.enjin.sdk.model.service.tokens.TokenSupplyModel;
import com.enjin.sdk.model.service.tokens.TokenTransferFeeSettings;
import com.enjin.sdk.model.service.tokens.TokenTransferable;

import com.enjin.sdk.service.requests.RequestsService;
import lombok.Builder;

/**
 * A data model for the Create Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class CreateTokenData {

    /**
     * The name of the token.
     *
     * -- SETTER --
     *
     * @param name the token name.
     * @return the builder.
     */
    private String name;

    /**
     * The total supply.
     *
     * -- SETTER --
     *
     * @param totalSupply the total supply.
     * @return the builder.
     */
    private Integer totalSupply;

    /**
     * The initial reserve.
     *
     * -- SETTER --
     *
     * @param initialReserve the initial reserve.
     * @return the builder.
     */
    private Integer initialReserve;

    /**
     * The supply model to use.
     *
     * -- SETTER --
     *
     * @param supplyModel the supply model.
     * @return the builder.
     */
    private TokenSupplyModel supplyModel;

    /**
     * The melt value.
     *
     * -- SETTER --
     *
     * @param meltValue the melt value.
     * @return the builder.
     */
    private String meltValue;

    /**
     * The melt fee ratio.
     *
     * -- SETTER --
     *
     * @param meltFeeRatio the melt fee ratio.
     * @return the builder.
     */
    private Integer meltFeeRatio;

    /**
     * Whether the token is transferable or not.
     *
     * -- SETTER --
     *
     * @param transferable the type.
     * @return the builder.
     */
    private TokenTransferable transferable;

    /**
     * The transfer fee settings.
     *
     * -- SETTER --
     *
     * @param transferFeeSettings the settings.
     * @return the builder.
     */
    private TokenTransferFeeSettings transferFeeSettings;

    /**
     * Whether the toke is fungible or non-fungible.
     *
     * -- SETTER --
     *
     * @param nonFungible is it a non-fungible?
     * @return the builder.
     */
    private Boolean nonFungible;

}
