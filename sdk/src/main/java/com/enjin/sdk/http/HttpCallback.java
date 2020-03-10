package com.enjin.sdk.http;

/**
 * A callback for http requests.
 *
 * @param <T> the type of the response body.
 *
 * @author Evan Lindsay
 */
public interface HttpCallback<T> {

    /**
     * Called when an http response has been processed.
     *
     * @param response the response.
     */
    void onComplete(HttpResponse<T> response);

}