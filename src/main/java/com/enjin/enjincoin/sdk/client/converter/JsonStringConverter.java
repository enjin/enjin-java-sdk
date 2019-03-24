package com.enjin.enjincoin.sdk.client.converter;

import com.enjin.enjincoin.sdk.client.annotation.Json;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class JsonStringConverter extends Converter.Factory {

    private final Converter.Factory delegate;

    public JsonStringConverter(final Converter.Factory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Converter<?, String> stringConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
        for (final Annotation annotation : annotations) {
            if (annotation instanceof Json) {
                final Converter<?, RequestBody> converter =
                        this.delegate.requestBodyConverter(type, annotations, new Annotation[0], retrofit);
                return new DelegateToStringConverter<>(converter);
            }
        }
        return null;
    }

    public static class DelegateToStringConverter<T> implements Converter<T, String> {

        private final Converter<T, RequestBody> delegate;

        public DelegateToStringConverter(final Converter<T, RequestBody> delegate) {
            this.delegate = delegate;
        }

        @Override
        public String convert(final T value) throws IOException {
            final Buffer buffer = new Buffer();
            this.delegate.convert(value).writeTo(buffer);
            return buffer.readUtf8();
        }
    }
}
