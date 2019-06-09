package com.enjin.enjincoin.sdk.graphql;

/**
 * Represents a model of a GraphQL request and
 * facilitates the serialization of the query.
 *
 * @author Evan Lindsay
 * @see GraphQLParameters
 * @see Builder
 */
public final class GraphQLRequest {

    private GraphQLParameters parameters;
    private String            query;

    private GraphQLRequest() {
        this.parameters = new GraphQLParameters();
    }

    /**
     * Returns a String of the formatted query with any formatted
     * parameters baked in.
     *
     * @return the formatted query
     *
     * @see GraphQLRequest
     * @see GraphQLParameters
     */
    public String getFormattedQuery() {
        return String.format(this.query, this.parameters.getFormattedParameters());
    }

    /**
     * A builder to facilitate the creation of a {@link GraphQLRequest}.
     */
    public static class Builder {

        private final GraphQLRequest request;

        /**
         * Creates a new instance of the builder.
         */
        public Builder() {
            this.request = new GraphQLRequest();
        }

        /**
         * Sets the request query.
         *
         * @param query the query.
         *
         * @return the builder.
         */
        public Builder withQuery(String query) {
            this.request.query = query;
            return this;
        }

        /**
         * Adds a parameter to be baked into the query.
         *
         * @param key   the parameter key.
         * @param value the parameter value.
         *
         * @return the builder.
         */
        public Builder withParameter(String key, Object value) {
            if (key != null && !key.isEmpty() && value != null) {
                this.request.parameters.getParameters().put(key, value);
            }
            return this;
        }

        /**
         * Returns the built {@link GraphQLRequest}.
         *
         * @return the request object.
         */
        public GraphQLRequest build() {
            if (this.request.query == null) {
                throw new IllegalStateException("A GraphQL query was not provided.");
            }
            return this.request;
        }

        public GraphQLParameters parameters() {
            return this.request.parameters;
        }

    }

    /**
     * Creates a new builder instance.
     *
     * @return the new builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

}
