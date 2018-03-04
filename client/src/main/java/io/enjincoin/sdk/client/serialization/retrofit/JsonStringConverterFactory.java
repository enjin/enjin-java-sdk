package io.enjincoin.sdk.client.serialization.retrofit;

import io.enjincoin.sdk.client.annotations.serialization.Json;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class JsonStringConverterFactory extends Converter.Factory {

    private final Converter.Factory delegate;

    public JsonStringConverterFactory(Converter.Factory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof Json) {
                Converter<?, RequestBody> converter =
                        delegate.requestBodyConverter(type, annotations, new Annotation[0], retrofit);
                return new DelegateToStringConverter<>(converter);
            }
        }
        return null;
    }

    public static class DelegateToStringConverter<T> implements Converter<T, String> {

        private final Converter<T, RequestBody> delegate;

        public DelegateToStringConverter(Converter<T, RequestBody> delegate) {
            this.delegate = delegate;
        }

        @Override
        public String convert(T value) throws IOException {
            Buffer buffer = new Buffer();
            delegate.convert(value).writeTo(buffer);
            return buffer.readUtf8();
        }
    }
}
