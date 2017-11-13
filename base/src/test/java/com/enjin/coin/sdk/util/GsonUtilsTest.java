package com.enjin.coin.sdk.util;

import org.junit.Test;

import com.google.gson.GsonBuilder;

import static org.assertj.core.api.Assertions.*;

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
