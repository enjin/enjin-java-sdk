package com.enjin.enjincoin.sdk.model.request;

public final class GraphQLRequest {

    private GraphQLParameters parameters;
    private String            query;

    private GraphQLRequest() {
        this.parameters = new GraphQLParameters();
    }

    public String getFormattedQuery() {
        return String.format(this.query, this.parameters.getFormattedParameters());
    }

    public static class Builder {

        private final GraphQLRequest request;

        public Builder() {
            this.request = new GraphQLRequest();
        }

        public Builder withQuery(final String query) {
            this.request.query = query;
            return this;
        }

        public Builder withParameter(final String key, final Object value) {
            if (key != null && !key.isEmpty() && value != null) {
                this.request.parameters.getParameters().put(key, value);
            }
            return this;
        }

        public GraphQLRequest build() {
            if (this.request.query == null) {
                throw new IllegalStateException("A GraphQL query was not provided.");
            }
            return this.request;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
