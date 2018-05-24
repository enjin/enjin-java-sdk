package com.enjin.enjincoin.sdk.client;

import com.enjin.enjincoin.sdk.client.service.GraphQLRetrofitService;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GraphQLRequest {

    private GraphQLRetrofitService service;
    private GraphQLParameters parameters;
    private String path;

    private GraphQLRequest(GraphQLRetrofitService service) {
        this.service = service;
        this.parameters = new GraphQLParameters();
    }

    public Call<JsonElement> call() {
        return this.service.query(getFormattedQuery());
    }

    public Response<JsonElement> execute() throws IOException {
        return call().execute();
    }

    public void enqueue(Callback<JsonElement> callback) {
        call().enqueue(callback);
    }

    private String getFormattedQuery() {
        String query = getQuery();
        return String.format(query, this.parameters.getFormattedParameters());
    }

    private String getQuery() {
        String query = "";

        try {
            URL url = getClass().getResource(this.path);
            Path path = Paths.get(url.toURI());
            byte[] data = Files.readAllBytes(path);
            query = new String(data).trim();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static class Builder {

        private GraphQLRequest request;

        public Builder(GraphQLRetrofitService service) {
            this.request = new GraphQLRequest(service);
        }

        public Builder withParameter(String key, Object value) {
            if (key != null && !key.isEmpty() && value != null) {
                this.request.parameters.getParameters().put(key, value);
            }
            return this;
        }

        public Builder fromResource(String path) {
            this.request.path = path;
            return this;
        }

        public GraphQLRequest build() {
            return this.request;
        }

    }

    public static Builder builder(GraphQLRetrofitService service) {
        return new Builder(service);
    }

}
