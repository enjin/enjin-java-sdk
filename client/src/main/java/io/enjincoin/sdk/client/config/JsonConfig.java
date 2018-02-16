package io.enjincoin.sdk.client.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.enjincoin.sdk.client.util.GsonUtils;
import io.enjincoin.sdk.client.util.JsonUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * <p>
 * Json Config that is used in the sdk.
 * </p>
 */
public class JsonConfig {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(JsonConfig.class.getName());

    /**
     * Gson variable to use.
     */
    private static final Gson GSON = GsonUtils.GSON_PRETTY_PRINT;

    /**
     * Class constructor.
     */
    protected JsonConfig() {

    }

    /**
     * Method to load config.
     * @param file file to load config from
     * @param clazz the class type of the config
     * @param <T> the class type of the config
     * @return T - jsonConfig
     * @throws Exception any exceptions that occur when loading the config
     */
    public static <T extends JsonConfig> T load(final File file, final Class<T> clazz) throws Exception {
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

    /**
     * Method to load config.
     * @param file file to load config from
     * @param clazz the class type of the config
     * @param <T> the class type of the config
     * @param loadNewSupplier to use
     * @return T - jsonConfig
     * @throws Exception any exceptions that occur when loading the config
     */
    public static <T extends JsonConfig> T load(final File file, final Class<T> clazz, final Supplier<T> loadNewSupplier) throws Exception {
        JsonConfig config = null;

        if (!file.exists() || file.length() == 0) {
            config = loadNewSupplier.get();
            config.save(file);
        } else {
            config = loadExisting(file, clazz);
        }

        if (config == null) {
            throw new Exception(String.format("Could not load config of type %s at %s.", clazz.getName(), file.getPath()));
        }

        return clazz.cast(config);
    }

    /**
     * Method to load new config.
     * @param clazz the class type of the config
     * @param <T> the class type of the config
     * @return <T> - JsonConfig
     * @throws Exception any exceptions that occur when loading the config
     */
    private static <T extends JsonConfig> T loadNew(final Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }

    /**
     * Method to load existing config.
     * @param file file to load config from
     * @param clazz the class type of the config
     * @param <T> the class type of the config
     * @return <T> - JsonConfig
     * @throws Exception any exceptions that occur when loading the config
     */
    @SuppressWarnings("unchecked")
    private static <T extends JsonConfig> T loadExisting(final File file, final Class<T> clazz) throws Exception {
        FileReader fileReader = new FileReader(file);

        return (T) JsonUtils.convertJsonFromFileReaderToObject(GSON, fileReader, clazz);
    }

    /**
     * Method to save config.
     * @param file file to save config to
     * @return boolean
     */
    public boolean save(final File file) {
        boolean success = true;

        try (FileWriter fw = new FileWriter(file)) {
            if (file.getParentFile() != null) {
                boolean mkdirsResult = file.getParentFile().mkdirs();
                LOGGER.fine(String.format("mkdirsResult is %s.", mkdirsResult));
            }
            if (!file.exists()) {
                boolean createNewFileResult = file.createNewFile();
                LOGGER.fine(String.format("createNewFileResult is %s.", createNewFileResult));
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

    /**
     * Method to update config.
     * @param file file to store the updated config
     * @param data date to write to the config
     * @return boolean
     */
    public boolean update(final File file, final Object data) {
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

    /**
     * Method to update config.
     * @param oldObj the old object
     * @param updatedObj the updated object
     */
    private void update(final JsonObject oldObj, final JsonObject updatedObj) {
        for (Map.Entry<String, JsonElement> entry : updatedObj.getAsJsonObject().entrySet()) {
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