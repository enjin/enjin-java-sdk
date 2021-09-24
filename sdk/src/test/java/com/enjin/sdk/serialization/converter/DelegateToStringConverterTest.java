/* Copyright 2021 Enjin Pte Ltd.
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

import com.enjin.sdk.serialization.converter.JsonStringConverter.DelegateToStringConverter;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Converter;

@ExtendWith(MockitoExtension.class)
class DelegateToStringConverterTest {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");

    @Mock(name = "delegate")
    private Converter<Object, RequestBody> mockConverter;

    @InjectMocks
    private DelegateToStringConverter<Object> classUnderTest;

    @Test
    @SneakyThrows
    void convert_ReturnsNonNullString() {
        // Arrange - Data
        final Object dummyObject = new Object();
        final RequestBody fakeResponseBody = RequestBody.create("", MEDIA_TYPE);

        // Arrange - Stubbing
        when(mockConverter.convert(dummyObject)).thenReturn(fakeResponseBody);

        // Act
        String actual = classUnderTest.convert(dummyObject);

        // Assert
        assertNotNull(actual);
    }

}
