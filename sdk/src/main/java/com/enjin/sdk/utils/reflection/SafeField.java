/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.utils.reflection;

import java.lang.reflect.Field;
import java.util.Optional;

import lombok.Getter;
import lombok.SneakyThrows;

/**
 * Class providing for safe reflection of class fields.
 */
public class SafeField {

    /**
     * -- GETTER --
     *
     * @return the field
     */
    @Getter
    private Field field;

    /**
     * Constructs a safe reflection field for the given field.
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
     *
     * @throws IllegalAccessException   if the Field object is enforcing Java language access control and the
     *                                  underlying field is inaccessible
     * @throws IllegalArgumentException if the specified object is not an instance of the class or interface declaring
     *                                  the underlying field (or a subclass or implementor thereof)
     */
    @SneakyThrows
    public <T> Optional<T> get(Object instance, Class<T> type) {
        Object value = field.get(instance);
        return type.isInstance(value)
                ? Optional.of(type.cast(value))
                : Optional.empty();
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
