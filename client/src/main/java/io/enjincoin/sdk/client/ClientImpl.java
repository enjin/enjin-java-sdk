package io.enjincoin.sdk.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.enjincoin.sdk.client.serialization.gson.IdentityFilterSerializer;
import io.enjincoin.sdk.client.serialization.retrofit.JsonStringConverterFactory;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import io.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ClientImpl implements Client {

    private OkHttpClient client;
    private Retrofit retrofit;
    private IdentitiesService identitiesService;

    public ClientImpl(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Converter.Factory gsonFactory = GsonConverterFactory.create(getGsonInstance());

        this.client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(new JsonStringConverterFactory(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    @Override
    public IdentitiesService getIdentitiesService() {
        if (identitiesService == null)
            identitiesService = new IdentitiesServiceImpl(retrofit);
        return identitiesService;
    }

    private Gson getGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
                .registerTypeAdapter(IdentityFilter.class, new IdentityFilterSerializer())
                .create();
    }

    @Override
    public void close() throws IOException {
        this.client.dispatcher().executorService().shutdown();
    }
}
