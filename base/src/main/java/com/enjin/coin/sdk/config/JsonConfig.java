package com.enjin.coin.sdk.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class JsonConfig {

    private static final Logger LOGGER = Logger.getLogger(JsonConfig.class.getName());
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Class constructor
     */
    protected JsonConfig() {
    	
    }
    
    public static <T extends JsonConfig> T load(File file, Class<T> clazz) throws Exception {
        JsonConfig config = null;

        if (!file.exists() || file.length() == 0) {
            config = loadNew(clazz);
            config.save(file);
        } else {
            config = loadExisting(file, clazz);
        }

        if (config == null) {
            throw new Exception(String.format("Could not load config of type %s at %s.", clazz.getName(), file.getPath()));
        }

        return clazz.cast(config);
    }

    private static <T extends JsonConfig> T loadNew(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }

    private static <T extends JsonConfig> T loadExisting(File file, Class<T> clazz) throws Exception {
        return GSON.fromJson(new FileReader(file), clazz);
    }

    public boolean save(File file) {
        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(GSON.toJson(this));
            fw.close();
        } catch (IOException e) {
            LOGGER.warning(String.format("Could not save the config to %s.", file.getName()));
            return false;
        }

        return true;
    }

    public boolean update(File file, Object data) {
        JsonElement old = GSON.toJsonTree(this);
        JsonElement updates = GSON.toJsonTree(data);

        if (!old.isJsonObject() && !updates.isJsonObject()) {
            LOGGER.warning(String.format("Could not update the config at %s as it or the updated data is not an object.", file.getName()));
            return false;
        }

        JsonObject oldObj = old.getAsJsonObject();
        JsonObject updatesObj = updates.getAsJsonObject();

        update(oldObj, updatesObj);

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(GSON.toJson(oldObj));
            fw.close();
        } catch (IOException e) {
            LOGGER.warning(String.format("Could not save the updated config to %s.", file.getName()));
            return false;
        }

        return true;
    }

    private void update(JsonObject oldObj, JsonObject update) {
        for (Map.Entry<String, JsonElement> entry : update.getAsJsonObject().entrySet()) {
            if (!oldObj.has(entry.getKey())) {
                LOGGER.fine(String.format("%s does not exists, updating value.", entry.getKey()));
                oldObj.add(entry.getKey(), entry.getValue());
                continue;
            }

            JsonElement element = oldObj.get(entry.getKey());
            if (entry.getValue().isJsonObject()) {
                LOGGER.fine(String.format("%s is an object, processing object fields.", entry.getKey()));
                update(element.getAsJsonObject(), element.getAsJsonObject());
            } else {
                LOGGER.fine(String.format("Setting %s to %s.", entry.getKey(), entry.getValue().toString()));
                oldObj.add(entry.getKey(), entry.getValue());
            }
        }
    }
}