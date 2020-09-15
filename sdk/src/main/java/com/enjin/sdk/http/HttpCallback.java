package com.enjin.sdk.http;

/**
 * A callback for HTTP requests.
 *
 * @param <T> the type of the response body
 */
public interface HttpCallback<T> {

    /**
     * Called when an HTTP response has been processed.
     *
     * @param response the response
     */
    void onComplete(HttpResponse<T> response);

}