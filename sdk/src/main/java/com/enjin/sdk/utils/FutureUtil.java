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
