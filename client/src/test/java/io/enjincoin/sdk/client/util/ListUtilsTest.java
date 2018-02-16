package io.enjincoin.sdk.client.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ListUtilsTest {

    @Test
    public void testConstructor() {
        ListUtils listUtils = new ListUtils();
        assertThat(listUtils).isNotNull();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsEmpty_List_False() {
        List list = new ArrayList() {{
            add("value");
        }};
        assertThat(ListUtils.isEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_List_TrueNull() {
        List list = null;
        assertThat(ListUtils.isEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_List_TrueEmpty() {
        List list = new ArrayList();
        assertThat(ListUtils.isEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_List_FalseEmpty() {
        List list = new ArrayList();
        assertThat(ListUtils.isNotEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_List_FalseNull() {
        List list = null;
        assertThat(ListUtils.isNotEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsNotEmpty_List_True() {
        List list = new ArrayList() {{
            add("value");
        }};
        assertThat(ListUtils.isNotEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsEmpty_OptionalList_False() {
        Optional<List> list = Optional.of(new ArrayList() {{
            add("value");
        }});
        assertThat(ListUtils.isEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalList_TrueNull() {
        Optional<List> list = null;
        assertThat(ListUtils.isEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalList_TrueEmptyEmpty() {
        Optional<List> list = Optional.of(new ArrayList());
        assertThat(ListUtils.isEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsEmpty_OptionalList_TrueEmpty() {
        Optional<List> list = Optional.ofNullable(null);
        assertThat(ListUtils.isEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "serial"})
    @Test
    public void testIsNotEmpty_OptionalList_True() {
        Optional<List> list = Optional.of(new ArrayList() {{
            add("value");
        }});
        assertThat(ListUtils.isNotEmpty(list)).isTrue();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalList_FalseNull() {
        Optional<List> list = null;
        assertThat(ListUtils.isNotEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalList_FalseEmptyEmpty() {
        Optional<List> list = Optional.of(new ArrayList());
        assertThat(ListUtils.isNotEmpty(list)).isFalse();
    }

    @SuppressWarnings({"rawtypes"})
    @Test
    public void testIsNotEmpty_OptionalList_FalseEmpty() {
        Optional<List> list = Optional.ofNullable(null);
        assertThat(ListUtils.isNotEmpty(list)).isFalse();
    }

}
