package com.enjin.sdk.utils;

import static com.google.common.truth.Truth.*;
import com.google.gson.JsonObject;
import org.junit.Test;

public class GsonUtilTest {

    private static final String DATA_KEY = "data";
    private static final String RESULT_KEY = "result";
    private static final String PATH = DATA_KEY + "." + RESULT_KEY;
    private static final JsonObject NO_RESULT = new JsonObject();
    private static final JsonObject HAS_RESULT = new JsonObject();

    static {
        JsonObject data = new JsonObject();
        NO_RESULT.add(DATA_KEY, data.deepCopy());
        data.add(RESULT_KEY, new JsonObject());
        HAS_RESULT.add(DATA_KEY, data);
    }

    @Test
    public void pathExists_isTrue() {
        assertThat(GsonUtil.pathExists(HAS_RESULT, PATH)).isTrue();
    }

}
