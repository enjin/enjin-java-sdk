package com.enjin.sdk.model.service.requests.data;

import java.util.Arrays;
import java.util.List;

import com.enjin.sdk.service.requests.RequestsService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;

/**
 * A data model for the Melt Token request type.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
@Builder
public class MeltTokenData {

    /**
     * The token id.
     *
     * -- SETTER --
     *
     * @param tokenId the token id.
     * @return the builder.
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The token index.
     *
     * -- SETTER --
     *
     * @param tokenIndex the token index.
     * @return the builder.
     */
    @SerializedName("token_index")
    private String tokenIndex;

    /**
     * The indexes of the token to melt.
     *
     * -- SETTER --
     *
     * @param tokenIndexes a list of token indexes.
     * @return the builder.
     */
    @SerializedName("token_index_array")
    private List<String> tokenIndexes;

    /**
     * The number of items to melt.
     *
     * -- SETTER --
     *
     * @param value the amount to melt.
     * @return the builder.
     */
    private Integer value;

    /**
     * The number of items to melt.
     *
     * -- SETTER --
     *
     * @param values the amounts to melt.
     * @return the builder.
     */
    @SerializedName("value_array")
    private List<Integer> values;

    public static class MeltTokenDataBuilder {
        /**
         * The indexes of the token to melt.
         *
         * -- SETTER --
         *
         * @param tokenIndexes a list of token indexes.
         *
         * @return the builder.
         */
        public MeltTokenDataBuilder tokenIndexes(String... tokenIndexes) {
            this.tokenIndexes = Arrays.asList(tokenIndexes);
            return this;
        }

        /**
         * The indexes of the token to melt.
         *
         * -- SETTER --
         *
         * @param tokenIndexes a list of token indexes.
         *
         * @return the builder.
         */
        public MeltTokenDataBuilder tokenIndexes(List<String> tokenIndexes) {
            this.tokenIndexes = tokenIndexes;
            return this;
        }

        /**
         * The number of items to melt.
         *
         * -- SETTER --
         *
         * @param values the amounts to melt.
         *
         * @return the builder.
         */
        public MeltTokenDataBuilder values(Integer... values) {
            this.values = Arrays.asList(values);
            return this;
        }

        /**
         * The number of items to melt.
         *
         * -- SETTER --
         *
         * @param values the amounts to melt.
         *
         * @return the builder.
         */
        public MeltTokenDataBuilder values(List<Integer> values) {
            this.values = values;
            return this;
        }
    }

}
