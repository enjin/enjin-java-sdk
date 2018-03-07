package io.enjincoin.sdk.client;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.enjincoin.sdk.client.serialization.gson.IdentityFilterSerializer;
import io.enjincoin.sdk.client.serialization.retrofit.JsonStringConverterFactory;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import io.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import io.enjincoin.sdk.client.service.identity.IdentityService;
import io.enjincoin.sdk.client.service.identity.impl.IdentityServiceImpl;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.service.requests.RequestsService;
import io.enjincoin.sdk.client.service.requests.impl.RequestsServiceImpl;
import io.enjincoin.sdk.client.service.tokens.TokensService;
import io.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import io.enjincoin.sdk.client.service.users.UsersService;
import io.enjincoin.sdk.client.service.users.impl.UsersServiceImpl;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientImpl implements Client {

    private OkHttpClient client;
    private Retrofit retrofit;
    private IdentitiesService identitiesService;
    private IdentityService identityService;
    private UsersService userService;
    private RequestsService requestsService;
    private TokensService tokensService;
    private PlatformService platformService;

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
        if (identitiesService == null) {
            identitiesService = new IdentitiesServiceImpl(retrofit);
        }
        return identitiesService;
    }

    @Override
    public IdentityService getIdentityService() {
        if (identityService == null) {
            identityService = new IdentityServiceImpl(retrofit);
        }
        return identityService;
    }
    @Override
    public UsersService getUsersService() {
        if (userService == null) {
            userService = new UsersServiceImpl(retrofit);
        }
        return userService;
    }
    @Override
    public RequestsService getRequestsService() {
        if (requestsService == null) {
            requestsService = new RequestsServiceImpl(retrofit);
        }
        return requestsService;
    }

    @Override
    public TokensService getTokensService() {
        if (tokensService == null) {
            tokensService = new TokensServiceImpl(retrofit);
        }
        return tokensService;
    }

    @Override
    public PlatformService getPlatformService() {
        if (platformService == null) {
            platformService = new PlatformServiceImpl(retrofit);
        }
        return platformService;
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
