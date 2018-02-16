package io.enjincoin.sdk.client.util;

import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GsonUtilsTest {

    @Test
    public void testConstructor() {
        GsonUtils gsonUtils = new GsonUtils();
        assertThat(gsonUtils).isNotNull();
    }

    @Test
    public void testRegisterAllTypeAdapterFactories() {
        GsonBuilder builder = new GsonBuilder();
        GsonUtils.registerAllTypeAdapterFactories(builder);
    }

}
