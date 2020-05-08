package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Set Whitelisted request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class SetWhitelistedData {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The account to be whitelisted.
     *
     * @param account the account.
     * @return the builder.
     */
    private String account;

    /**
     * The whitelist setting for this account address.
     *
     * @param whitelisted the settings.
     * @return the builder.
     */
    private String whitelisted;

    /**
     * Whether the whitelist setting is on or off.
     *
     * @param on whether the setting is on or off.
     * @return the builder.
     */
    private Boolean on;

}
