/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.serialization.converter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import com.enjin.sdk.serialization.Json;

import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * A converter factory for {@link DelegateToStringConverter}.
 */
public class JsonStringConverter extends Converter.Factory {

    private final Converter.Factory delegate;

    /**
     * Creates a new factory instance.
     *
     * @param delegate the delegate converter factory
     */
    protected JsonStringConverter(Converter.Factory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Converter<?, String> stringConverter(Type type,
                                                Annotation[] annotations,
                                                Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof Json) {
                final Converter<?, RequestBody> converter =
                        this.delegate.requestBodyConverter(type, annotations, new Annotation[0], retrofit);
                return new DelegateToStringConverter<>(converter);
            }
        }
        return null;
    }

    /**
     * Creates a new factory instance.
     *
     * @param delegate the delegate converter factory
     * @return a new json string convert
     */
    public static JsonStringConverter create(Converter.Factory delegate) {
        return new JsonStringConverter(delegate);
    }

    /**
     * Converts an object to json.
     *
     * @param <T> the type of the object being converted
     */
    public static class DelegateToStringConverter<T> implements Converter<T, String> {

        private final Converter<T, RequestBody> delegate;

        /**
         * Creates a new converter instance.
         *
         * @param delegate the delegate converter.
         */
        public DelegateToStringConverter(Converter<T, RequestBody> delegate) {
            this.delegate = delegate;
        }

        @Override
        public String convert(T value) throws IOException {
            try (Buffer buffer = new Buffer()) {
                this.delegate.convert(value).writeTo(buffer);
                return buffer.readUtf8();
            }
        }
    }

}
