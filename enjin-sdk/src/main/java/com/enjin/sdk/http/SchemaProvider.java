package com.enjin.sdk.http;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

public class SchemaProvider implements Supplier<String> {

    public static final String DEFAULT_SCHEMA = "default";

    @Getter
    @Setter
    private String schema = DEFAULT_SCHEMA;

    @Override
    public String get() {
        return schema;
    }

}
