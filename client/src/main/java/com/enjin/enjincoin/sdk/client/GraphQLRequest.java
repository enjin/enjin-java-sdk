package com.enjin.enjincoin.sdk.client;

import com.enjin.enjincoin.sdk.client.service.GraphQLResponse;
import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class GraphQLRequest {

    private GraphQLRetrofitService service;
    private GraphQLParameters parameters;
    private String path;

    private GraphQLRequest(final GraphQLRetrofitService service) {
        this.service = service;
        this.parameters = new GraphQLParameters();
    }

    public Call<GraphQLResponse> call() {
        return this.service.query(getFormattedQuery());
    }

    public Response<GraphQLResponse> execute() throws IOException {
        return call().execute();
    }

    public void enqueue(final Callback<GraphQLResponse> callback) {
        call().enqueue(callback);
    }

    private String getFormattedQuery() {
        final String query = getQuery();
        return String.format(query, this.parameters.getFormattedParameters());
    }

    private String getQuery() {
        String query = "";

        try {
            final URL url = getClass().getResource(this.path);
            final Path path = Paths.get(url.toURI());
            final byte[] data = Files.readAllBytes(path);
            query = new String(data).trim();
        } catch (final URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static class Builder {

        private final GraphQLRequest request;

        public Builder(final GraphQLRetrofitService service) {
            this.request = new GraphQLRequest(service);
        }

        public Builder withParameter(final String key, final Object value) {
            if (key != null && !key.isEmpty() && value != null) {
                this.request.parameters.getParameters().put(key, value);
            }
            return this;
        }

        public Builder fromResource(final String path) {
            this.request.path = path;
            return this;
        }

        public GraphQLRequest build() {
            return this.request;
        }

    }

    public static Builder builder(final GraphQLRetrofitService service) {
        return new Builder(service);
    }

}
