package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.http.ClearableCookieJar;
import com.enjin.enjincoin.sdk.http.CookieCache;
import com.enjin.enjincoin.sdk.http.CookiePersistor;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.http.MemoryCookiePersistor;
import com.enjin.enjincoin.sdk.http.PersistentCookieJar;
import com.enjin.enjincoin.sdk.http.SetCookieCache;
import com.enjin.enjincoin.sdk.http.SimpleCallback;
import com.enjin.enjincoin.sdk.model.service.auth.AuthBody;
import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.enjincoin.sdk.serialization.BigIntegerDeserializer;
import com.enjin.enjincoin.sdk.serialization.converter.GraphConverter;
import com.enjin.enjincoin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.enjincoin.sdk.service.auth.AuthRetrofitService;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.service.platform.impl.PlatformServiceImpl;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.requests.impl.RequestsServiceImpl;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.service.users.impl.UsersServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import lombok.Getter;
import okhttp3.Cookie;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TrustedPlatformClient implements Closeable {

    // Trusted Platform Base URLs
    public static final String MAIN_NET           = "https://cloud.enjin.io/";
    public static final String KOVAN              = "https://kovan.cloud.enjin.io/";
    // Keys
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    public static final String AUTHORIZATION      = "Authorization";

    // Cookie Jar
    private CookieCache            cookieCache;
    private CookiePersistor        cookiePersistor;
    private ClearableCookieJar     cookieJar;
    // Http Client
    private HttpLoggingInterceptor httpLogInterceptor;
    private OkHttpClient           httpClient;
    // Serialization
    private Gson                   gson;
    private Converter.Factory      gsonFactory;
    private Retrofit               retrofit;
    // Services
    @Getter
    private AuthRetrofitService    authService;
    @Getter
    private PlatformService        platformService;
    @Getter
    private UsersService           usersService;
    @Getter
    private IdentitiesService      identitiesService;
    @Getter
    private RequestsService        requestsService;
    @Getter
    private TokensService          tokensService;

    public TrustedPlatformClient() {
        this(new Builder());
    }

    protected TrustedPlatformClient(Builder builder) {
        this.cookieCache = new SetCookieCache();
        this.cookiePersistor = new MemoryCookiePersistor();
        this.cookieJar = new PersistentCookieJar(this.cookieCache, this.cookiePersistor);

        this.httpLogInterceptor = builder.httpLogInterceptor;
        this.httpClient = builder.httpClientBuilder
                .cookieJar(this.cookieJar)
                .addInterceptor(this.httpLogInterceptor)
                .build();

        this.gson = builder.gsonBuilder
                .serializeSpecialFloatingPointValues()
                .create();
        this.gsonFactory = GsonConverterFactory.create(this.gson);
        this.retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl)
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(JsonStringConverter.create(this.gsonFactory))
                .addConverterFactory(this.gsonFactory)
                .build();

        this.authService = this.retrofit.create(AuthRetrofitService.class);
        this.platformService = new PlatformServiceImpl(this.retrofit);
        this.usersService = new UsersServiceImpl(this.retrofit);
        this.identitiesService = new IdentitiesServiceImpl(this.retrofit);
        this.requestsService = new RequestsServiceImpl(this.retrofit);
        this.tokensService = new TokensServiceImpl(this.retrofit);
    }

    public void setHttpLogLevel(Level level) {
        this.httpLogInterceptor.setLevel(level == null ? Level.NONE : level);
    }

    public HttpResponse<AuthResult> authAppSync(int appId, String appSecret) throws IOException {
        long                 start    = System.currentTimeMillis();
        Call<AuthResult>     call     = authApp(appId, appSecret);
        Response<AuthResult> response = call.execute();

        authApp(start, response);

        return new HttpResponse<>(response.code(), response.body());
    }

    public void authAppAsync(int appId, String appSecret, HttpCallback<AuthResult> callback) {
        long             start = System.currentTimeMillis();
        Call<AuthResult> call  = authApp(appId, appSecret);

        call.enqueue(new SimpleCallback<AuthResult>() {
            @Override
            public void onResponse(Call<AuthResult> call, Response<AuthResult> response) {
                authApp(start, response);
                if (callback != null) {
                    callback.onComplete(new HttpResponse<>(response.code(), response.body()));
                }
            }
        });
    }

    private Call<AuthResult> authApp(int appId, String appSecret) {
        return this.authService.auth(AuthBody.builder()
                                             .grantType(CLIENT_CREDENTIALS)
                                             .clientId(String.valueOf(appId))
                                             .clientSecret(appSecret)
                                             .build());
    }

    private void authApp(long start, Response<AuthResult> response) {
        if (response.isSuccessful()) {
            AuthResult body = response.body();
            this.cookieJar.addCookie(new Cookie.Builder()
                                             .domain(this.retrofit.baseUrl().host())
                                             .name(AUTHORIZATION)
                                             .value(String.format("%s %s", body.getTokenType(), body.getAccessToken()))
                                             .expiresAt(start + TimeUnit.SECONDS.toMillis(body.getExpiresIn()))
                                             .build());
        }
    }

    @Override
    public void close() throws IOException {
        Dispatcher dispatcher = this.httpClient.dispatcher();
        ExecutorService executorService = dispatcher.executorService();

        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    public static class Builder<T extends Builder<T>> {

        private HttpUrl                baseUrl;
        private HttpLoggingInterceptor httpLogInterceptor;
        private OkHttpClient.Builder   httpClientBuilder;
        private GsonBuilder            gsonBuilder;

        public Builder() {
            this.baseUrl = HttpUrl.get(MAIN_NET);
            this.httpLogInterceptor = new HttpLoggingInterceptor();
            this.httpClientBuilder = new OkHttpClient.Builder();
            this.gsonBuilder = new GsonBuilder()
                    .registerTypeAdapter(BigInteger.class, new BigIntegerDeserializer());
        }

        public T httpLogLevel(Level level) {
            this.httpLogInterceptor.setLevel(level == null ? Level.NONE : level);
            return (T) this;
        }

        public T connectTimeout(long timeout, TimeUnit unit) {
            this.httpClientBuilder.connectTimeout(timeout, unit);
            return (T) this;
        }

        public T callTimeout(long timeout, TimeUnit unit) {
            this.httpClientBuilder.callTimeout(timeout, unit);
            return (T) this;
        }

        public T readTimeout(long timeout, TimeUnit unit) {
            this.httpClientBuilder.readTimeout(timeout, unit);
            return (T) this;
        }

        public T writeTimeout(long timeout, TimeUnit unit) {
            this.httpClientBuilder.writeTimeout(timeout, unit);
            return (T) this;
        }

        public T baseUrl(String url) {
            this.baseUrl = HttpUrl.get(url == null || url.isEmpty() ? MAIN_NET : url);
            return (T) this;
        }

        public T mainNet() {
            baseUrl(MAIN_NET);
            return (T) this;
        }

        public T kovan() {
            baseUrl(KOVAN);
            return (T) this;
        }

        public T addTypeAdapter(Type type, Object adapter) {
            this.gsonBuilder.registerTypeAdapter(type, adapter);
            return (T) this;
        }

        public T addTypeAdapterFactory(TypeAdapterFactory factory) {
            this.gsonBuilder.registerTypeAdapterFactory(factory);
            return (T) this;
        }

        public T addTypeHierchyAdapter(Class<?> baseType, Object adapter) {
            this.gsonBuilder.registerTypeHierarchyAdapter(baseType, adapter);
            return (T) this;
        }

        public TrustedPlatformClient build() {
            return new TrustedPlatformClient(this);
        }

    }

}
