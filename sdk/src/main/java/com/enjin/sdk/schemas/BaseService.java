package com.enjin.sdk.schemas;

import java.util.logging.Level;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;

import com.enjin.sdk.serialization.converter.GraphConverter;
import com.enjin.sdk.serialization.converter.JsonStringConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TODO
 */
@Log
public class BaseService {

    private final Retrofit retrofit;
    @Getter
    private final TrustedPlatformMiddleware middleware;

    private BaseService() {
        throw new IllegalStateException(/* TODO: Exception message. */);
    }

    public BaseService(TrustedPlatformMiddleware middleware) {
        this.middleware = middleware;

        // Serialization
        Gson gson = new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .create();
        Converter.Factory gsonFactory = GsonConverterFactory.create(gson);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.middleware.getBaseUrl())
                .client(this.middleware.getHttpClient())
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(JsonStringConverter.create(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    /**
     * Executes a http request.
     *
     * @param call the request call
     * @param <T>  the type of the request and response
     * @return     the response
     */
    @SneakyThrows
    protected <T> HttpResponse<T> execute(Call<T> call) {
        retrofit2.Response<T> response = call.execute();
        return new HttpResponse<>(response.code(), response.body());
    }

    /**
     * Queues a http request.
     *
     * @param call     the request call
     * @param callback the callback
     * @param <T>      the type of the request and response
     */
    protected <T> void enqueue(Call<T> call, final HttpCallback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                callback.onComplete(new HttpResponse<>(response.code(), response.body()));
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                BaseService.log.log(Level.WARNING, "There was an error while processing a request or a response.", t);
            }
        });
    }

    /**
     * TODO
     * @param service
     * @param <T>
     * @return
     */
    protected <T> Object createService(@NotNull Class<T> service) {
        return retrofit.create(service);
    }

}
