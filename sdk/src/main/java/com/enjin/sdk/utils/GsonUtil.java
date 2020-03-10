package com.enjin.sdk.utils;

import com.github.dmstocking.optional.java.util.Optional;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public final class GsonUtil {

    private GsonUtil() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean pathExists(JsonObject root, String path) {
        String[] keys = path.split("\\.");
        return pathExists(root, keys, 0);
    }

    private static boolean pathExists(JsonObject node, String[] keys, int keyIndex) {
        if (!node.has(keys[keyIndex]))
            return false;

        if (keyIndex == keys.length - 1)
            return true;

        JsonElement next = node.get(keys[keyIndex]);

        if (!next.isJsonObject())
            return false;

        return pathExists(next.getAsJsonObject(), keys, keyIndex + 1);
    }

    /**
     * Gets an element from the provided path for the provided object.
     *
     * @param root the object to search in
     * @param path the path to fetch
     *
     * @return empty optional if path does not exist or is null, else optional wrapped element
     */
    public static Optional<JsonElement> getJsonElement(JsonObject root, String path) {
        String[] keys = path.split("\\.");
        return getJsonElement(root, keys, 0);
    }

    private static Optional<JsonElement> getJsonElement(JsonElement node, String[] keys, int keyIndex) {
        if (keyIndex == keys.length)
            return Optional.of(node);

        if (!node.isJsonObject())
            return Optional.empty();

        JsonObject obj = node.getAsJsonObject();

        if (!obj.has(keys[keyIndex]))
            return Optional.empty();

        return getJsonElement(obj.get(keys[keyIndex]), keys, keyIndex + 1);
    }

    public static boolean isJsonObject(Optional<JsonElement> optional) {
        return optional.isPresent() && optional.get().isJsonObject();
    }

    public static boolean isJsonArray(Optional<JsonElement> optional) {
        return optional.isPresent() && optional.get().isJsonArray();
    }

}
