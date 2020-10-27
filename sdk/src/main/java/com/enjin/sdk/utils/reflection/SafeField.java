package com.enjin.sdk.utils.reflection;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.enjin.sdk.utils.LoggerProvider;
import lombok.Getter;
import lombok.NonNull;

/**
 * Class providing for safe reflection of class fields.
 */
public class SafeField {

    /**
     * -- GETTER --
     * @return the field
     */
    @Getter
    private Field field;

    /**
     * -- Getter --
     * @return the logger provider
     */
    @Getter
    private final LoggerProvider loggerProvider;

    /**
     * Constructs a safe reflection field for the given field.
     *
     * @param field the field
     */
    public SafeField(Field field) {
        this(field, new LoggerProvider(Logger.getGlobal()));
    }

    /**
     * Constructs a safe reflection that uses the given logger provider.
     *
     * @param field the field
     * @param loggerProvider the logger provider
     */
    public SafeField(Field field, @NonNull LoggerProvider loggerProvider) {
        this.field = field;
        this.loggerProvider = loggerProvider;
    }

    /**
     * Gets the value assigned to the instance field and casts it to the provided type.
     *
     * @param instance the object instance
     * @param type the value type
     * @param <T> the type to cast to
     * @return empty optional if unable to get value or value is null, else wrapped value
     */
    public <T> Optional<T> get(Object instance, Class<T> type) {
        try {
            Object value = field.get(instance);
            if (type.isInstance(value))
                return Optional.of(type.cast(value));
        } catch (IllegalAccessException e) {
            loggerProvider.log(Level.WARNING, String.format("Unable to get field value: %s", field.getName()));
        }

        return Optional.empty();
    }

    /**
     * Gets the value assigned to a class field and casts it to the provided type.
     *
     * @param type the value type
     * @param <T> the type to cast to
     * @return empty optional if unable to get value or value is null, else wrapped value
     */
    public <T> Optional<T> getStatic(Class<T> type) {
        return get(null, type);
    }

}
