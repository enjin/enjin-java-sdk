package com.enjin.sdk.models.request.data;

import com.enjin.sdk.models.request.TokenTransferFeeSettingsInput;
import com.enjin.sdk.models.token.TokenSupplyModel;
import com.enjin.sdk.models.token.TokenTransferable;

import com.enjin.sdk.services.request.RequestsService;
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
     * @param name the token name.
     * @return the builder.
     */
    private String name;

    /**
     * The total supply.
     *
     * @param totalSupply the total supply.
     * @return the builder.
     */
    private Integer totalSupply;

    /**
     * The initial reserve.
     *
     * @param initialReserve the initial reserve.
     * @return the builder.
     */
    private Integer initialReserve;

    /**
     * The supply model to use.
     *
     * @param supplyModel the supply model.
     * @return the builder.
     */
    private TokenSupplyModel supplyModel;

    /**
     * The melt value.
     *
     * @param meltValue the melt value.
     * @return the builder.
     */
    private String meltValue;

    /**
     * The melt fee ratio.
     *
     * @param meltFeeRatio the melt fee ratio.
     * @return the builder.
     */
    private Integer meltFeeRatio;

    /**
     * Whether the token is transferable or not.
     *
     * @param transferable the type.
     * @return the builder.
     */
    private TokenTransferable transferable;

    /**
     * The transfer fee settings.
     *
     * @param transferFeeSettings the settings.
     * @return the builder.
     */
    private TokenTransferFeeSettingsInput transferFeeSettings;

    /**
     * Whether the toke is fungible or non-fungible.
     *
     * @param nonFungible is it a non-fungible?
     * @return the builder.
     */
    private Boolean nonFungible;

    /**
     * The icon.
     *
     * @param icon the icon.
     * @return the builder.
     */
    private String icon;

}
