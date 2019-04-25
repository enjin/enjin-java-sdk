package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.http.AuthenticationInterceptor;
import com.enjin.enjincoin.sdk.http.ClearableCookieJar;
import com.enjin.enjincoin.sdk.http.MemoryCookiePersistor;
import com.enjin.enjincoin.sdk.http.PersistentCookieJar;
import com.enjin.enjincoin.sdk.http.SetCookieCache;
import com.enjin.enjincoin.sdk.model.service.auth.AuthBody;
import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.enjincoin.sdk.serialization.BigIntegerDeserializer;
import com.enjin.enjincoin.sdk.serialization.converter.GraphConverter;
import com.enjin.enjincoin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.enjincoin.sdk.service.auth.AuthRetrofitService;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.service.ethereum.impl.EthereumServiceImpl;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.enjincoin.sdk.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.service.notifications.impl.NotificationsServiceImpl;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.service.platform.impl.PlatformServiceImpl;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.requests.impl.RequestsServiceImpl;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.service.users.impl.UsersServiceImpl;
import com.enjin.enjincoin.sdk.http.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;
import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.math.BigInteger;

public class ClientImpl implements Client {

    private String               url;
    private String               appId;
    private OkHttpClient         client;
    private Retrofit             retrofit;
    private AuthRetrofitService  authRetrofitService;
    private EthereumService      ethereumService;
    private IdentitiesService    identitiesService;
    private UsersService         userService;
    private RequestsService      requestsService;
    private TokensService        tokensService;
    private PlatformService      platformService;
    private NotificationsService notificationsService;

    private ClearableCookieJar cookieJar;

    public ClientImpl(final String url, final String appId, final boolean log) {
        this.url = url;
        this.appId = appId;
        this.cookieJar = new PersistentCookieJar(new SetCookieCache(), new MemoryCookiePersistor());

        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.cookieJar(this.cookieJar);
        clientBuilder.addInterceptor(new AuthenticationInterceptor(this.cookieJar));

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

    public Result<AuthResult> auth(String clientSecret) throws IOException {
        Call<AuthResult> call = getAuthRetrofitService()
                .auth(AuthBody.builder()
                              .grantType("client_credentials")
                              .clientId(this.appId)
                              .clientSecret(clientSecret)
                              .build());
        // Failure needs to be handled by the callee.
        retrofit2.Response<AuthResult> response = call.execute();

        if (response == null) {
            return null;
        }

        if (response.isSuccessful()) {
            AuthResult data = response.body();
            this.cookieJar.addCookie(new Cookie.Builder()
                                             .domain(this.retrofit.baseUrl().host()).name("laravel_session_type")
                                             .value(data.getTokenType())
                                             .build());
            this.cookieJar.addCookie(new Cookie.Builder()
                                             .domain(this.retrofit.baseUrl().host()).name("laravel_session")
                                             .value(String.format("%s@%s", this.appId, data.getAccessToken()))
                                             .build());
        }

        return new Result<>(response.code(), response.body());
    }

    private AuthRetrofitService getAuthRetrofitService() {
        if (this.authRetrofitService == null) {
            this.authRetrofitService = this.retrofit.create(AuthRetrofitService.class);
        }
        return this.authRetrofitService;
    }

    @Override
    public String getAppId() {
        return this.appId;
    }

    @Override
    public EthereumService getEthereumService() {
        if (this.ethereumService == null) {
            this.ethereumService = new EthereumServiceImpl(retrofit);
        }
        return this.ethereumService;
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
            this.notificationsService = new NotificationsServiceImpl(getPlatformService(), this.appId);
        }

        return this.notificationsService;
    }

    private Gson getGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer())
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
