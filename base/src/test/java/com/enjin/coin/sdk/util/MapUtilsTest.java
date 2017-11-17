package com.enjin.coin.sdk.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

public class MapUtilsTest {

    @Test
    public void testConstructor() {
        MapUtils mapUtils = new MapUtils();
        assertThat(mapUtils).isNotNull();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsEmpty_Map_False() {
        Map map = new HashMap() {{
            put("key", "value");
        }};
        assertThat(MapUtils.isEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_Map_TrueNull() {
        Map map = null;
        assertThat(MapUtils.isEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_Map_TrueEmpty() {
        Map map = new HashMap();
        assertThat(MapUtils.isEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_Map_FalseEmpty() {
        Map map = new HashMap();
        assertThat(MapUtils.isNotEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_Map_FalseNull() {
        Map map = null;
        assertThat(MapUtils.isNotEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void testIsNotEmpty_Map_True() {
        Map map = new HashMap();
        map.put("key", "value");
        assertThat(MapUtils.isNotEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsEmpty_OptionalMap_False() {
        Optional<Map> map = Optional.of(new HashMap() {{
            put("key", "value");
        }});
        assertThat(MapUtils.isEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalMap_TrueNull() {
        Optional<Map> map = null;
        assertThat(MapUtils.isEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalMap_TrueEmptyEmpty() {
        Optional<Map> map = Optional.of(new HashMap());
        assertThat(MapUtils.isEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalMap_TrueEmpty() {
        Optional<Map> map = Optional.ofNullable(null);
        assertThat(MapUtils.isEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsNotEmpty_OptionalMap_True() {
        Optional<Map> map = Optional.of(new HashMap() {{
            put("key", "value");
        }});
        assertThat(MapUtils.isNotEmpty(map)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalMap_FalseNull() {
        Optional<Map> map = null;
        assertThat(MapUtils.isNotEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalMap_FalseEmptyEmpty() {
        Optional<Map> map = Optional.of(new HashMap());
        assertThat(MapUtils.isNotEmpty(map)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalMap_FalseEmpty() {
        Optional<Map> map = Optional.ofNullable(null);
        assertThat(MapUtils.isNotEmpty(map)).isFalse();
    }

}
