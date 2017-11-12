package com.enjin.coin.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public final class GsonUtils {

    public static final Gson GSON;

    static {
        GsonBuilder builder = new GsonBuilder()
                .serializeNulls();
        GsonUtils.registerAllTypeAdapterFactories(builder);
        GSON = builder.create();
    }

    private GsonUtils() {
    }

    public static void registerAllTypeAdapterFactories(GsonBuilder builder) {
        for (TypeAdapterFactory factory : getAllTypeAdapterFactories()) {
            builder.registerTypeAdapterFactory(factory);
        }
    }

    public static List<TypeAdapterFactory> getAllTypeAdapterFactories() {
        List<TypeAdapterFactory> factories = new ArrayList<>();
        getTypeAdapterFactoryServiceLoader().forEach(factories::add);
        return factories;
    }

    public static ServiceLoader<TypeAdapterFactory> getTypeAdapterFactoryServiceLoader() {
        return ServiceLoader.load(TypeAdapterFactory.class);
    }

}
