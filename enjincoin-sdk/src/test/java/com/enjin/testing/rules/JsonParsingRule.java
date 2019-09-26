package com.enjin.testing.rules;

import static com.google.common.truth.Truth.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.enjin.testing.JsonFileResource;
import com.enjin.testing.JsonFileResources;
import com.enjin.testing.JsonModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import kotlin.text.Charsets;

public class JsonParsingRule implements TestRule {

    private final Gson                    gson;
    private final Map<Integer, JsonModel> models;

    public JsonParsingRule(Gson gson) {
        this.gson = gson;
        this.models = new HashMap<>();
    }

    public JsonModel getModel(int index) {
        return models.get(index);
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                models.clear();

                JsonFileResources jsonFileResources = description.getAnnotation(JsonFileResources.class);
                JsonFileResource  jsonFileResource  = description.getAnnotation(JsonFileResource.class);

                assertThat(jsonFileResources != null && jsonFileResource != null).isFalse();

                if (jsonFileResources != null) {
                    for (JsonFileResource resource : jsonFileResources.resources()) {
                        processResource(resource, description);
                    }
                }

                if (jsonFileResource != null) {
                    processResource(jsonFileResource, description);
                }

                base.evaluate();
            }
        };
    }

    private void processResource(JsonFileResource resource, Description description) throws IOException {
        if (resource == null)
            return;

        Class<?>    targetClass  = getTypeToken(resource).getRawType();
        String      resourceName = resource.fileName();
        Class<?>    testClass    = description.getTestClass();
        InputStream in           = testClass.getResourceAsStream(resourceName);
        assertThat(in).isNotNull();

        try (Reader reader = new BufferedReader(new InputStreamReader(in, Charsets.UTF_8))) {
            JsonElement element = gson.fromJson(reader, JsonElement.class);
            Object value = gson.fromJson(element, targetClass);
            JsonModel model = new JsonModel(resource, element, value);
            models.put(models.size(), model);
        }
    }


    private TypeToken getTypeToken(JsonFileResource resource) {
        if (resource.parameters().length > 0)
            return TypeToken.getParameterized(resource.targetClass(), resource.parameters());

        return TypeToken.get(resource.targetClass());
    }

}
