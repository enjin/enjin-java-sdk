package com.enjin.sdk.graphql;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * A class for serializing objects in a GraphQL format.
 */
public class GraphQLObjectSerializer {

    private Object obj;
    private StringBuilder builder;

    /**
     * Constructs the serializer around the provided object.
     *
     * @param obj the object to be serialized.
     */
    public GraphQLObjectSerializer(Object obj) {
        this.obj = obj;
    }

    /**
     * Serializes the object.
     *
     * @return the serialized object.
     */
    public String serialize() {
        builder = new StringBuilder();
        serialize(obj);
        return builder.toString();
    }

    private void serialize(Object obj) {
        if (obj instanceof String || obj instanceof Character) {
            builder.append("\"")
                   .append(obj)
                   .append("\"");
        } else if (obj instanceof Number) {
            builder.append(obj);
        } else if (obj instanceof Boolean) {
            builder.append(((Boolean) obj) ? "true" : "false");
        } else if (obj instanceof Enum) {
            builder.append(((Enum) obj).name());
        } else if (obj instanceof Iterable) {
            serializeIterable((Iterable) obj);
        } else if (obj instanceof Array) {
            serializeArray((Array) obj);
        } else {
            serializeObject(obj);
        }
    }

    private void serializeIterable(Iterable iterable) {
        boolean first = true;
        builder.append('[');

        for (Object obj : iterable) {
            if (first) {
                first = false;
            } else {
                builder.append(',');
            }

            serialize(obj);
        }

        builder.append(']');
    }

    private void serializeArray(Array array) {
        serializeIterable(Arrays.asList(array));
    }

    private void serializeObject(Object obj) {
        builder.append('{');

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object val = field.get(obj);

                if (val == null)
                    continue;

                String name = field.getName();

                if (field.isAnnotationPresent(SerializedName.class)) {
                    SerializedName annotation = field.getAnnotation(SerializedName.class);
                    name = annotation.value();
                }

                if (first) {
                    first = false;
                } else {
                    builder.append(',');
                }

                builder.append(name)
                       .append(':');

                serialize(val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        builder.append('}');
    }

}
