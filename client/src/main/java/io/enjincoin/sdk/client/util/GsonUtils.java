package io.enjincoin.sdk.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import io.enjincoin.sdk.client.Client;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

/**
 * <p>
 * Sets up the Gson object.
 * </p>
 */
public final class GsonUtils {

    /**
     * Standard gson element.
     **/
    public static final Gson GSON;
    /**
     * Gson element with pretty print configured.
     **/
    public static final Gson GSON_PRETTY_PRINT;

    static {
        GsonBuilder builder = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builder);
        GSON = builder.registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory()).create();

        GsonBuilder builderPrettyPrint = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builderPrettyPrint);
        builderPrettyPrint.setPrettyPrinting();
        GSON_PRETTY_PRINT = builderPrettyPrint.registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory()).create();
    }

    /**
     * Class constructor.
     */
    protected GsonUtils() {
    }

    /**
     * Method to register all type adapter factories.
     *
     * @param gsonBuilder gson configure to configer
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
        return factories;
    }

    /**
     * Method to get the type adapter factory service loader.
     *
     * @return ServiceLoader
     */
    public static ServiceLoader<TypeAdapterFactory> getTypeAdapterFactoryServiceLoader() {
        return getTypeAdapterFactoryServiceLoader(Client.class.getClassLoader());
    }

    /**
     * Method to get the type adapter factory service loader for the given ClassLoader.
     *
     * @param classLoader the given ClassLoader
     *
     * @return ServiceLoader
     */
    public static ServiceLoader<TypeAdapterFactory> getTypeAdapterFactoryServiceLoader(final ClassLoader classLoader) {
        return ServiceLoader.load(TypeAdapterFactory.class, classLoader);
    }

}
