package com.enjin.coin.sdk.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MapUtils.class)
public class MapUtilsTest {

    @Test
    public void testConstructor() {
        MapUtils mapUtils = new MapUtils();
        assertNotNull(mapUtils);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void testIsEmpty_Map_False() {
        Map map = new HashMap();
        map.put("key", "value");
        boolean isEmpty = MapUtils.isEmpty(map);
        assertFalse(isEmpty);
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_Map_TrueNull() {
        Map map = null;
        boolean isEmpty = MapUtils.isEmpty(map);
        assertTrue(isEmpty);
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_Map_TrueEmpty() {
        Map map = new HashMap();
        boolean isEmpty = MapUtils.isEmpty(map);
        assertTrue(isEmpty);
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_Map_FalseEmpty() {
        Map map = new HashMap();
        boolean isEmpty = MapUtils.isNotEmpty(map);
        assertFalse(isEmpty);
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_Map_FalseNull() {
        Map map = null;
        boolean isEmpty = MapUtils.isNotEmpty(map);
        assertFalse(isEmpty);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void testIsNotEmpty_Map_True() {
        Map map = new HashMap();
        map.put("key", "value");
        boolean isEmpty = MapUtils.isNotEmpty(map);
        assertTrue(isEmpty);
    }

}
