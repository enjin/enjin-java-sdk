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

package com.enjin.sdk.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Utility class for use with {@link Future}.
 */
public final class FutureUtil {

    private FutureUtil() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Returns a future that contains the given exception.
     *
     * @param e the exception
     * @param <T> type parameter of the future
     * @return the future
     */
    public static <T> Future<T> failedFuture(Throwable e) {
        CompletableFuture<T> future = new CompletableFuture<>();
        future.completeExceptionally(e);
        return future;
    }

}
