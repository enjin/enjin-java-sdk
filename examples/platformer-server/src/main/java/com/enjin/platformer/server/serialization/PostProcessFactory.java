package com.enjin.platformer.server.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

public class PostProcessFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!PostProcessable.class.isAssignableFrom(type.getRawType()))
            return null;
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        return new PostProcessAdapter<>(delegate);
    }

    @RequiredArgsConstructor
    public class PostProcessAdapter<T> extends TypeAdapter<T> {

        private final TypeAdapter<T> delegate;

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            delegate.write(out, value);
        }

        @Override
        public T read(JsonReader in) throws IOException {
            Object obj = delegate.read(in);
            if (obj instanceof PostProcessable)
                ((PostProcessable) obj).process();
            return (T) obj;
        }
    }

}
