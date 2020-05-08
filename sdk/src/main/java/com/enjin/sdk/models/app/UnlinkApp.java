package com.enjin.sdk.models.app;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.services.app.AppsService;

/**
 * An object class for unlinking a wallet from an application on the Trusted Platform.
 *
 * @see AppsService
 */
public class UnlinkApp extends GraphQLRequest<UnlinkApp> implements AppFragment<UnlinkApp> {

    /**
     * The application id.
     *
     * @param id the app id
     * @return   this request
     */
    public UnlinkApp appId(Integer id) {
        set("id", id);
        return this;
    }

    /**
     * The Ethereum address of the wallet.
     *
     * @param ethAddr the wallet's Ethereum address
     * @return        this request
     */
    public UnlinkApp ethAddress(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

}
