package com.enjin.sdk.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class SafeReflection {

    private SafeReflection() {
    }

    /**
     * Gets a list of safe fields that match the provided type and modifiers.
     *
     * @param clazz     the class to search
     * @param type      the field type
     * @param modifiers the field modifiers
     *
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
     * @param field     the field
     * @param modifiers the modifiers
     *
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
