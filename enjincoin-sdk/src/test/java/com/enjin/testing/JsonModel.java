package com.enjin.testing;

import com.google.gson.JsonElement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonModel {

    @Getter
    private final JsonFileResource resource;
    @Getter
    private final JsonElement      rawValue;
    private final Object           value;

    @SuppressWarnings({"unchecked", "TypeParameterUnusedInFormals"})
    public <T> T getValue() {
        return (T) value;
    }

}
