package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.gson.GsonBuilder;

public class GsonUtilsTest {

    @Test
    public void testConstructor() {
        GsonUtils gsonUtils = new GsonUtils();
        assertNotNull(gsonUtils);
    }
    
    @Test
    public void testRegisterAllTypeAdapterFactories() {
    	GsonBuilder builder = new GsonBuilder();
    	GsonUtils.registerAllTypeAdapterFactories(builder);
    }

   
}
