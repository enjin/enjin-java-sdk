package com.enjin.sdk.models.request.data;

import java.util.Arrays;
import java.util.List;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Mint Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class MintTokenData {

    /**
     * The token id.
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The token index.
     *
     * @param tokenIndex the token index.
     * @return the builder.
     */
    @SerializedName("token_index")
    private String tokenIndex;

    /**
     * The Ethereum address to send the newly minted item to.
     *
     * @param recipientAddress the Ethereum address.
     * @return the builder.
     */
    @SerializedName("recipient_address")
    private String recipientAddress;

    /**
     * An array of addresses to send the newly minted items to.
     *
     * @param recipientAddresses the array of Ethereum addresses.
     * @return the builder.
     */
    @SerializedName("recipient_address_array")
    private List<String> recipientAddresses;

    /**
     * The identity id of the wallet to send the newly minted item to.
     *
     * @param recipientIdentityId the identity id.
     * @return the builder.
     */
    @SerializedName("recipient_identity_id")
    private Integer recipientIdentityId;

    /**
     * An array of identity ids to send the newly minted items to.
     *
     * @param recipientIdentityIds the array of identity ids.
     * @return the builder.
     */
    @SerializedName("recipient_identity_id_array")
    private List<Integer> recipientIdentityIds;

    /**
     * The number of items to mint.
     *
     * @param value the amount to mint.
     * @return the builder.
     */
    private Integer value;

    /**
     * The amount to mint for each address/identity id.
     *
     * @param values the amounts to mint.
     * @return the builder.
     */
    @SerializedName("value_array")
    private List<Integer> values;

    public static class MintTokenDataBuilder {
        /**
         * An array of addresses to send the newly minted items to.
         *
         * @param recipientAddresses the array of Ethereum addresses.
         * @return the builder.
         */
        public MintTokenDataBuilder recipientAddress(String... recipientAddresses) {
            this.recipientAddresses = Arrays.asList(recipientAddresses);
            return this;
        }

        /**
         * An array of addresses to send the newly minted items to.
         *
         * @param recipientAddresses the array of Ethereum addresses.
         * @return the builder.
         */
        public MintTokenDataBuilder recipientAddress(List<String> recipientAddresses) {
            this.recipientAddresses = recipientAddresses;
            return this;
        }

        /**
         * An array of identity ids to send the newly minted items to.
         *
         * @param recipientIdentityIds the array of identity ids.
         * @return the builder.
         */
        @SerializedName("recipient_identity_id_array")
        public MintTokenDataBuilder recipientIdentityIds(Integer... recipientIdentityIds) {
            this.recipientIdentityIds = Arrays.asList(recipientIdentityIds);
            return this;
        }

        /**
         * An array of identity ids to send the newly minted items to.
         *
         * @param recipientIdentityIds the array of identity ids.
         * @return the builder.
         */
        @SerializedName("recipient_identity_id_array")
        public MintTokenDataBuilder recipientIdentityIds(List<Integer> recipientIdentityIds) {
            this.recipientIdentityIds = recipientIdentityIds;
            return this;
        }

        /**
         * The amount to mint for each address/identity id.
         *
         * @param values the amounts to mint.
         * @return the builder.
         */
        public MintTokenDataBuilder values(Integer... values) {
            this.values = Arrays.asList(values);
            return this;
        }

        /**
         * The amount to mint for each address/identity id.
         *
         * @param values the amounts to mint.
         * @return the builder.
         */
        public MintTokenDataBuilder values(List<Integer> values) {
            this.values = values;
            return this;
        }
    }

}
