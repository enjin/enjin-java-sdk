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

package com.enjin.sdk.http;

/**
 * A callback for HTTP requests.
 *
 * @param <T> the type of the response body
 */
public interface HttpCallback<T> {

    /**
     * Called when the HTTP response has been processed.
     *
     * @param response the response
     */
    void onComplete(HttpResponse<T> response);

    /**
     * Called when a throwable is produced due to an issue communicating with the server or when an exception occurs.
     * <p>
     *     Default implementation is to do nothing. May be overridden to provide functionality.
     * </p>
     *
     * @param throwable the throwable
     */
    default void onException(Throwable throwable) {
    }

}