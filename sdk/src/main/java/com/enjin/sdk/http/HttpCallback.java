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