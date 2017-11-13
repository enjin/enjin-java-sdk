package com.enjin.coin.sdk.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public final class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    protected FileUtils() {
    }

    /**
     * Method to get file contents into a string
     *
     * @param filePath
     * @return
     */
    public static String getFileContents(String filePath) {
        String fileContents = null;
        if (StringUtils.isEmpty(filePath)) {
            LOGGER.warning("filePath passed in is null or empty");
            return fileContents;
        }

        try {
            Path path = Paths.get(filePath);
            byte[] fileBytes = Files.readAllBytes(path);
            if (ObjectUtils.isNull(fileBytes) || ArrayUtils.getLength(fileBytes) == 0) {
                LOGGER.warning(String.format("No content returned for the file: %s", filePath));
                return fileContents;
            }
            fileContents = new String(fileBytes);
        } catch (IOException e) {
            LOGGER.warning(String.format("An IOException has occured. Exception: %s", StringUtils.exceptionToString(e)));
        }

        return fileContents;
    }

}
