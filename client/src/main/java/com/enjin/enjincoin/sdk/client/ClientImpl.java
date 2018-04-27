package com.enjin.enjincoin.sdk.client;

import java.io.IOException;

import com.enjin.enjincoin.sdk.client.serialization.gson.IdentityFilterSerializer;
import com.enjin.enjincoin.sdk.client.serialization.retrofit.JsonStringConverterFactory;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import com.enjin.enjincoin.sdk.client.service.identity.IdentityService;
import com.enjin.enjincoin.sdk.client.service.identity.impl.IdentityServiceImpl;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.client.service.requests.impl.RequestsServiceImpl;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import com.enjin.enjincoin.sdk.client.service.users.impl.UsersServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.enjin.enjincoin.sdk.client.serialization.gson.IdentityFilterSerializer;
import com.enjin.enjincoin.sdk.client.serialization.retrofit.JsonStringConverterFactory;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.enjincoin.sdk.client.service.identities.vo.IdentityFilter;
import com.enjin.enjincoin.sdk.client.service.identity.IdentityService;
import com.enjin.enjincoin.sdk.client.service.identity.impl.IdentityServiceImpl;
import com.enjin.enjincoin.sdk.client.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.client.service.notifications.impl.NotificationsServiceImpl;
import com.enjin.enjincoin.sdk.client.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import com.enjin.enjincoin.sdk.client.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.client.service.requests.impl.RequestsServiceImpl;
import com.enjin.enjincoin.sdk.client.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import com.enjin.enjincoin.sdk.client.service.users.UsersService;
import com.enjin.enjincoin.sdk.client.service.users.impl.UsersServiceImpl;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientImpl implements Client {

    private int appId;
    private OkHttpClient client;
    private Retrofit retrofit;
    private IdentitiesService identitiesService;
    private IdentityService identityService;
    private UsersService userService;
    private RequestsService requestsService;
    private TokensService tokensService;
    private PlatformService platformService;
    private NotificationsService notificationsService;

    public ClientImpl(String url, int appId, boolean log) {
        this.appId = appId;
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (log) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }

        Converter.Factory gsonFactory = GsonConverterFactory.create(getGsonInstance());

        this.client = clientBuilder.build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(new JsonStringConverterFactory(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    @Override
    public int getAppId() {
        return this.appId;
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


    @Override
    public NotificationsService getNotificationsService() {
        if (notificationsService == null) {
            notificationsService = new NotificationsServiceImpl(getPlatformService(), appId);
        }

        return notificationsService;
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
        if (this.notificationsService != null)
            this.notificationsService.shutdown();
    }
}
