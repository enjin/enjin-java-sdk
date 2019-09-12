package com.enjin.sdk.model.service.auth;

import com.enjin.sdk.service.auth.AuthRetrofitService;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.ToString;

/**
 * The body of an oauth authentication request to the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see AuthRetrofitService
 */
@Builder
@ToString
public class AuthBody {

    /**
     * At this time the trusted platform supports "client_credentials".
     *
     * -- SETTER --
     *
     * @param grantType the grant type.
     * @return the builder.
     */
    @SerializedName("grant_type")
    private String grantType;

    /**
     * The app id to authenticate.
     *
     * -- SETTER --
     *
     * @param clientId the app id.
     * @return the builder.
     */
    @SerializedName("client_id")
    private String clientId;

    /**
     * The app secret.
     *
     * -- SETTER --
     *
     * @param clientSecret the app secret.
     * @return the builder.
     */
    @SerializedName("client_secret")
    private String clientSecret;

}
