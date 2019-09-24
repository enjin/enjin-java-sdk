package com.enjin.enjincoin.sdk.reflection;

import com.github.dmstocking.optional.java.util.Optional;
import lombok.Getter;
import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.util.logging.Level;

@Log
public class SafeField {

    @Getter
    private Field field;

    public SafeField(Field field) {
        this.field = field;
    }

    public <T> Optional<T> get(Object instance, Class<T> type) {
        try {
            Object value = field.get(instance);
            if (type.isInstance(value))
                return Optional.of(type.cast(value));
        } catch (IllegalAccessException e) {
            SafeField.log.log(Level.WARNING, String.format("Unable to get field value: %s", field.getName()));
        }

        return Optional.empty();
    }

    public <T> Optional<T> getStatic(Class<T> type) {
        return get(null, type);
    }

}
