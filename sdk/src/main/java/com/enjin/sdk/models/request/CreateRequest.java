package com.enjin.sdk.models.request;

import com.enjin.sdk.services.request.RequestsService;

/**
 * A builder for creating a new request on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see RequestsService
 */
public class CreateRequest extends BaseRequest<CreateRequest> {

    public CreateRequest() {
        super(true);
    }

    public CreateRequest appId(Integer appId) {
        set("appId", appId);
        return this;
    }

    public CreateRequest ethAddr(String ethAddr) {
        set("ethAddr", ethAddr);
        return this;
    }

    /**
     * The id of the identity this request was created for.
     *
     * @param identityId the identity id.
     *
     * @return builder.
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
     * @return the builder.
     */
    public CreateRequest disableTest() {
        set("test", false);
        return this;
    }

    /**
     * When true a transaction will be tested, but won't be saved or sent. This is handy
     * if you wish test settings without submitting any blockchain transactions.
     *
     * @return the builder.
     */
    public CreateRequest testOnly() {
        set("dummy", true);
        return this;
    }

}
