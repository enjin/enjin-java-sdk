package com.enjin.sdk.models.request.data;

import com.enjin.sdk.services.request.RequestsService;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;

/**
 * A data model for the Release Reserve request type.
 *
 * @see RequestsService
 */
@Builder
public class ReleaseReserveData {

    /**
     * The token id.
     *
     * @param tokenId the token id
     * @return        the builder
     */
    @SerializedName("token_id")
    private String tokenId;

    /**
     * The number of tokens to release.
     *
     * @param value the number of tokens
     * @return      the builder
     */
    private Integer value;

}
