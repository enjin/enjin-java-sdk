package com.enjin.sdk.gen;

public enum TemplateType {

    FRAGMENT,
    MUTATION,
    QUERY;

    public boolean matches(String token) {
        return token.toUpperCase().equals(name());
    }

    public static TemplateType fromKey(String name) {
        for (TemplateType type : values()) {
            if (name.toUpperCase().endsWith(type.name()))
                return type;
        }

        throw new RuntimeException(String.format("Could not find existing template type for file name: %s", name));
    }

}
