package com.enjin.enjincoin.sdk.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class SafeReflection {

    private SafeReflection() {
    }

    public static List<SafeField> getFieldsOfTypeWithModifiers(Class<?> target, Class<?> type, int... modifiers) {
        List<SafeField> fields = new ArrayList<>();

        for (Field field : target.getDeclaredFields()) {
            if (field.getType() != type)
                continue;
            if (!hasModifiers(field, modifiers))
                continue;
            fields.add(new SafeField(field));
        }

        return fields;
    }

    public static boolean hasModifiers(Field field, int... modifiers) {
        int mod = field.getModifiers();

        for (int modifier : modifiers) {
            if ((mod & modifier) == 0)
                return false;
        }

        return true;
    }

}
