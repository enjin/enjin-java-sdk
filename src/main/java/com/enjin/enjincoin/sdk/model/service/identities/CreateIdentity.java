package com.enjin.enjincoin.sdk.model.service.identities;

import com.enjin.enjincoin.sdk.graphql.GraphQLRequest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * A builder for creating a new identity on the Trusted platform.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.identities.IdentitiesService
 */
public class CreateIdentity extends GraphQLRequest<CreateIdentity> {

    /**
     * The user id to create the new identity for.
     *
     * @param userId the users id.
     *
     * @return the builder.
     */
    public CreateIdentity userId(BigInteger userId) {
        withParameter("user_id", userId);
        return this;
    }

    /**
     * The user email to create the new identity for.
     *
     * @param email the users email.
     *
     * @return the builder.
     */
    public CreateIdentity email(String email) {
        withParameter("email", email);
        return this;
    }

    /**
     * The ethereum address to assign to the created identity.
     *
     * @param ethereumAddress the ethereum address.
     *
     * @return the builder.
     */
    public CreateIdentity ethAddr(String ethereumAddress) {
        withParameter("ethereum_address", ethereumAddress);
        return this;
    }

    /**
     * The fields to assign to the created identity.
     *
     * @param fields the fields.
     *
     * @return the builder.
     */
    public CreateIdentity fields(List<IdentityFieldInput> fields) {
        withParameter("fields", fields);
        return this;
    }

    /**
     * The fields to assign to the created identity.
     *
     * @param fields the fields.
     *
     * @return the builder.
     */
    public CreateIdentity fields(IdentityFieldInput... fields) {
        withParameter("fields", Arrays.asList(fields));
        return this;
    }

}
