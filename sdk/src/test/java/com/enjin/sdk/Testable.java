package com.enjin.sdk;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public interface Testable {

    @SneakyThrows
    static Field getField(Class c, String fieldName) {
        Field field = c.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }

}
