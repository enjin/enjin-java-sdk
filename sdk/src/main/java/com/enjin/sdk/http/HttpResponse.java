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

package com.enjin.sdk.http;

import lombok.ToString;

/**
 * An HTTP response wrapper.
 *
 * @param <T> the type of the body
 */
@ToString
public class HttpResponse<T> {

    private int code;
    private T body;

    /**
     * Creates a new http response with the code returned by the destination and the deserialized body.
     *
     * @param code the response code
     * @param body the response body
     */
    public HttpResponse(int code, T body) {
        this.code = code;
        this.body = body;
    }

    /**
     * The status code returned by the destination.
     *
     * @return the code
     */
    public int code() {
        return code;
    }

    /**
     * The deserialized body returned by the destination.
     *
     * @return the body
     */
    public T body() {
        return body;
    }

    /**
     * True if the code is in the range [200-300).
     *
     * @return true if 2xx, else false
     */
    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }

    /**
     * Returns whether or not there exists a body or not.
     *
     * @return true if there is no body, else false
     */
    public boolean isEmpty() {
        return this.body == null;
    }
}
