package io.enjincoin.sdk.client.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.gson.GsonBuilder;

import io.enjincoin.sdk.client.util.GsonUtils;

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
