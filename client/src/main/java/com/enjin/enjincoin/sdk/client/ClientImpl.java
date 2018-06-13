package com.enjin.enjincoin.sdk.client;

import com.enjin.enjincoin.sdk.client.converter.GraphConverter;
import com.enjin.enjincoin.sdk.client.converter.JsonStringConverter;
import com.enjin.enjincoin.sdk.client.cookiejar.ClearableCookieJar;
import com.enjin.enjincoin.sdk.client.cookiejar.PersistentCookieJar;
import com.enjin.enjincoin.sdk.client.cookiejar.cache.SetCookieCache;
import com.enjin.enjincoin.sdk.client.cookiejar.persistence.MemoryCookiePersistor;
import com.enjin.enjincoin.sdk.client.service.auth.AuthRetrofitService;
import com.enjin.enjincoin.sdk.client.service.auth.vo.AuthBody;
import com.enjin.enjincoin.sdk.client.service.auth.vo.AuthData;
import com.enjin.enjincoin.sdk.client.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ClientImpl implements Client {

    private String url;
    private String clientId;
    private OkHttpClient client;
    private Retrofit retrofit;
    private AuthRetrofitService authRetrofitService;
    private IdentitiesService identitiesService;
    private UsersService userService;
    private RequestsService requestsService;
    private TokensService tokensService;
    private PlatformService platformService;
    private NotificationsService notificationsService;

    private ClearableCookieJar cookieJar;

    public ClientImpl(final String url, final String clientId, final boolean log) {
        this.url = url;
        this.clientId = clientId;
        this.cookieJar = new PersistentCookieJar(new SetCookieCache(), new MemoryCookiePersistor());

        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.cookieJar(this.cookieJar);

        if (log) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }

        final Converter.Factory gsonFactory = GsonConverterFactory.create(getGsonInstance());

        this.client = clientBuilder.build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(this.client)
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(new JsonStringConverter(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();
    }

    public Response<AuthData> auth(String clientSecret) throws IOException {
        Call<AuthData> call = getAuthRetrofitService()
                .auth(new AuthBody("client_credentials", this.clientId, clientSecret));
        // Failure needs to be handled by the callee.
        Response<AuthData> response = call.execute();

        if (response.isSuccessful()) {
            AuthData data = response.body();
            Cookie cookie = new Cookie.Builder()
                    .domain(this.retrofit.baseUrl().host())
                    .name("laravel_session")
                    .value(String.format("%s@%s", this.clientId, data.getAccessToken()))
                    .build();
            this.cookieJar.addCookie(cookie);
        }

        return response;
    }

    public AuthRetrofitService getAuthRetrofitService() {
        if (this.authRetrofitService == null) {
            this.authRetrofitService = this.retrofit.create(AuthRetrofitService.class);
        }
        return this.authRetrofitService;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public IdentitiesService getIdentitiesService() {
        if (this.identitiesService == null) {
            this.identitiesService = new IdentitiesServiceImpl(retrofit);
        }
        return this.identitiesService;
    }

    @Override
    public UsersService getUsersService() {
        if (this.userService == null) {
            this.userService = new UsersServiceImpl(retrofit);
        }
        return this.userService;
    }
    @Override
    public RequestsService getRequestsService() {
        if (this.requestsService == null) {
            this.requestsService = new RequestsServiceImpl(retrofit);
        }
        return this.requestsService;
    }

    @Override
    public TokensService getTokensService() {
        if (this.tokensService == null) {
            this.tokensService = new TokensServiceImpl(retrofit);
        }
        return this.tokensService;
    }

    @Override
    public PlatformService getPlatformService() {
        if (this.platformService == null) {
            this.platformService = new PlatformServiceImpl(retrofit);
        }
        return this.platformService;
    }


    @Override
    public NotificationsService getNotificationsService() {
        if (this.notificationsService == null) {
            this.notificationsService = new NotificationsServiceImpl(getPlatformService(), this.clientId);
        }

        return this.notificationsService;
    }

    private Gson getGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
                .create();
    }

    @Override
    public void close() throws IOException {
        this.client.dispatcher().executorService().shutdown();
        if (this.notificationsService != null) {
            this.notificationsService.shutdown();
        }
    }
}
