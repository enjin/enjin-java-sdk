package com.enjin.sdk.utils.reflection;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.logging.Level;

import lombok.Getter;
import lombok.extern.java.Log;

/**
 * Class providing for safe reflection of class fields.
 */
@Log
public class SafeField {

    /**
     * -- GETTER --
     * Returns the reflected field.
     *
     * @return the field
     */
    @Getter
    private Field field;

    /**
     * Constructor for safe field reflection.
     *
     * @param field the field
     */
    public SafeField(Field field) {
        this.field = field;
    }

    /**
     * Gets the value assigned to the instance field and casts it to the provided type.
     *
     * @param instance the object instance
     * @param type     the value type
     * @param <T>      the type to cast to
     *
     * @return empty optional if unable to get value or value is null, else wrapped value
     */
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

    /**
     * Gets the value assigned to a class field and casts it to the provided type.
     *
     * @param type the value type
     * @param <T>  the type to cast to
     *
     * @return empty optional if unable to get value or value is null, else wrapped value
     */
    public <T> Optional<T> getStatic(Class<T> type) {
        return get(null, type);
    }

}
