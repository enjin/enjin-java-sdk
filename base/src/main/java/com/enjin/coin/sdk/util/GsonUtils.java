package com.enjin.coin.sdk.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.enjin.coin.sdk.vo.event.GsonAdaptersGetEventDataBalancesVO;
import com.enjin.coin.sdk.vo.event.GsonAdaptersGetEventDataVO;
import com.enjin.coin.sdk.vo.event.GsonAdaptersGetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GsonAdaptersGetEventResponseVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersCreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersCreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersDeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersDeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersGetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersGetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersUpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GsonAdaptersUpdateIdentityResponseVO;
import com.enjin.coin.sdk.vo.token.GsonAdaptersGetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GsonAdaptersGetTokenResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersCancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersCancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersCreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersCreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersGetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GsonAdaptersGetTransactionRequestResponseVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

/**
 * <p>
 * Sets up the Gson object.
 * </p>
 */
public final class GsonUtils {

    /** Standard gson element. **/
    public static final Gson GSON;
    /** Gson element with pretty print configured. **/
    public static final Gson GSON_PRETTY_PRINT;

    static {
        GsonBuilder builder = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builder);
        GSON = builder.create();

        GsonBuilder builderPrettyPrint = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builderPrettyPrint);
        builderPrettyPrint.setPrettyPrinting();
        GSON_PRETTY_PRINT = builderPrettyPrint.create();
    }

    /**
     * Class constructor.
     */
    protected GsonUtils() {
    }

    /**
     * Method to register all type adapter factories.
     *
     * @param gsonBuilder gson builder to configer
     */
    public static void registerAllTypeAdapterFactories(final GsonBuilder gsonBuilder) {
        for (TypeAdapterFactory factory : getAllTypeAdapterFactories()) {
            gsonBuilder.registerTypeAdapterFactory(factory);
        }
    }

    /**
     * Method to get all type adapter factories.
     *
     * @return List
     */
    public static List<TypeAdapterFactory> getAllTypeAdapterFactories() {
        List<TypeAdapterFactory> factories = new ArrayList<>();
        getTypeAdapterFactoryServiceLoader().forEach(factories::add);

        // TODO: remove - temporarily needed by damien - should not need to be added
        // here
        // These adapters are not registering when I run my tests in eclipse or intelliJ
        factories.add(new GsonAdaptersGetEventRequestVO());
        factories.add(new GsonAdaptersGetEventResponseVO());
        factories.add(new GsonAdaptersGetEventDataVO());
        factories.add(new GsonAdaptersGetEventDataBalancesVO());
        factories.add(new GsonAdaptersGetTransactionRequestRequestVO());
        factories.add(new GsonAdaptersGetTransactionRequestResponseVO());
        factories.add(new GsonAdaptersCreateTransactionRequestRequestVO());
        factories.add(new GsonAdaptersCreateTransactionRequestResponseVO());
        factories.add(new GsonAdaptersCancelTransactionRequestRequestVO());
        factories.add(new GsonAdaptersCancelTransactionRequestResponseVO());
        factories.add(new GsonAdaptersGetIdentityRequestVO());
        factories.add(new GsonAdaptersGetIdentityResponseVO());
        factories.add(new GsonAdaptersUpdateIdentityRequestVO());
        factories.add(new GsonAdaptersUpdateIdentityResponseVO());
        factories.add(new GsonAdaptersCreateIdentityRequestVO());
        factories.add(new GsonAdaptersCreateIdentityResponseVO());
        factories.add(new GsonAdaptersDeleteIdentityRequestVO());
        factories.add(new GsonAdaptersDeleteIdentityResponseVO());
        factories.add(new GsonAdaptersGetTokenRequestVO());
        factories.add(new GsonAdaptersGetTokenResponseVO());
        return factories;
    }

    /**
     * Method to get the type adapter factory service loader.
     *
     * @return ServiceLoader
     */
    public static ServiceLoader<TypeAdapterFactory> getTypeAdapterFactoryServiceLoader() {
        return ServiceLoader.load(TypeAdapterFactory.class);
    }

}
