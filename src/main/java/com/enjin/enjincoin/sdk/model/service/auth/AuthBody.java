package com.enjin.enjincoin.sdk.model.service.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

/**
 * The body of an oauth authentication request to the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.auth.AuthRetrofitService
 */
@Builder
public class AuthBody {

    /**
     * At this time the trusted platform supports "client_credentials".
     *
     * @param grantType the grant type.
     * @return the builder.
     */
    @SerializedName("grant_type")
    private String grantType;

    /**
     * The app id to authenticate.
     *
     * @param clientId the app id.
     * @return the builder.
     */
    @SerializedName("client_id")
    private String clientId;

    /**
     * The app secret.
     *
     * @param clientSecret the app secret.
     * @return the builder.
     */
    @SerializedName("client_secret")
    private String clientSecret;

}
