package com.enjin.sdk.models.request;

import com.enjin.sdk.models.app.App;
import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.services.request.RequestsService;

/**
 * An object class for creating a new request on the Trusted Platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class CreateRequest extends BaseRequest<CreateRequest> {

    /**
     * Sole constructor.
     */
    public CreateRequest() {
        super(true);
    }

    /**
     * The id of the {@link App}.
     *
     * @param appId the app id.
     * @return      this request.
     */
    public CreateRequest appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    /**
     * The Ethereum address of the {@link Identity} the request was created for.
     *
     * @param ethAddr the Ethereum address.
     * @return        this request.
     */
    public CreateRequest ethAddr(String ethAddr) {
        set("ethAddr", ethAddr);
        return this;
    }

    /**
     * The id of the {@link Identity} this request was created for.
     *
     * @param identityId the identity id.
     * @return           this request.
     */
    public CreateRequest identityId(int identityId) {
        set("identityId", identityId);
        return this;
    }

    /**
     * Whether to test the request prior to creating it. By default this is set to true.
     * Disabling tests means that gas fees will be lost if a transaction fails on the
     * blockchain. Disable with caution.
     *
     * @return this request.
     */
    public CreateRequest disableTest() {
        set("test", false);
        return this;
    }

    /**
     * When true a transaction will be tested, but won't be saved or sent. This is handy
     * if you wish test settings without submitting any blockchain transactions.
     *
     * @return this request.
     */
    public CreateRequest testOnly() {
        set("dummy", true);
        return this;
    }

}
