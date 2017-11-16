package com.enjin.coin.sdk.config;

import com.enjin.coin.sdk.util.GsonUtils;
import com.enjin.coin.sdk.util.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Json Config that is used in the sdk</p>
 */
public class JsonConfig {

    //Local log variable
    private static final Logger LOGGER = Logger.getLogger(JsonConfig.class.getName());

    //Gson variable to use
    private static final Gson GSON = GsonUtils.GSON_PRETTY_PRINT;

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

    @SuppressWarnings("unchecked")
    private static <T extends JsonConfig> T loadExisting(File file, Class<T> clazz) throws Exception {
        FileReader fileReader = new FileReader(file);
        return (T) JsonUtils.convertJsonFromFileReaderToObject(GSON, fileReader, clazz);
    }

    public boolean save(File file) {
        boolean success = true;
        try (FileWriter fw = new FileWriter(file)) {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            String jsonStr = JsonUtils.convertObjectToJson(GSON, this);
            fw.write(jsonStr);
            fw.close();
        } catch (IOException e) {
            LOGGER.warning(String.format("Could not save the config to %s.", file.getName()));
            success = false;
        }
        return success;
    }

    public boolean update(File file, Object data) {
        JsonElement old = JsonUtils.convertObjectToJsonTree(GSON, this);
        JsonElement updates = JsonUtils.convertObjectToJsonTree(GSON, data);

        boolean success = true;
        if (!old.isJsonObject() && !updates.isJsonObject()) {
            LOGGER.warning(String.format("Could not update the config at %s as it or the updated data is not an object.", file.getName()));
            success = false;
        } else {
            JsonObject oldObj = old.getAsJsonObject();
            JsonObject updatesObj = updates.getAsJsonObject();

            update(oldObj, updatesObj);

            try (FileWriter fw = new FileWriter(file)) {
                String jsonStr = JsonUtils.convertObjectToJson(GSON, oldObj);
                fw.write(jsonStr);
                fw.close();
            } catch (IOException e) {
                LOGGER.warning(String.format("Could not save the updated config to %s.", file.getName()));
                success = false;
            }
        }
        return success;
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