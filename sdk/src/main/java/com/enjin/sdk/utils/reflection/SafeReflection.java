/* Copyright 2021 Enjin Pte Ltd.
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
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class providing methods for safe reflections.
 */
public final class SafeReflection {

    private SafeReflection() {
    }

    /**
     * Gets a list of safe fields that match the provided type and modifiers.
     *
     * @param clazz the class to search
     * @param type the field type
     * @param modifiers the field modifiers
     * @return a list of safe fields
     */
    public static List<SafeField> getFieldsOfTypeWithModifiers(Class<?> clazz, Class<?> type, int... modifiers) {
        List<SafeField> fields = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType() != type || !hasModifiers(field, modifiers))
                continue;

            fields.add(new SafeField(field));
        }

        return fields;
    }

    /**
     * Returns whether the field has the provided modifiers.
     *
     * @param field the field
     * @param modifiers the modifiers
     * @return true if field has modifiers, else false
     */
    public static boolean hasModifiers(Field field, int... modifiers) {
        int mod = field.getModifiers();

        for (int modifier : modifiers) {
            if ((mod & modifier) == 0)
                return false;
        }

        return true;
    }

}
