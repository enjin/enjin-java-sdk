package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

/**
 * A data model that defines the tokens to approve for a Set Approval request.
 *
 * @author Evan Lindsay
 * @see SetApprovalData
 * @see com.enjin.enjincoin.sdk.service.requests.RequestsService
 */
@Builder
public class TokenIndexPairData {

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

}
