package com.enjin.sdk.models.app.data;

import com.enjin.sdk.services.app.AppsService;
import lombok.Builder;

/**
 * Configuration options for applications.
 *
 * @see AppsService
 */
@Builder
public class AppOptionsData {

    /**
     * Enables the token proof feature.
     */
    private Boolean tokenProofEnabled;

    /**
     * The token proof feature url.
     */
    private String tokenProofUrl;

    /**
     * Enables weak challenge by default.
     */
    private Boolean weakChallengeDefault;

}
