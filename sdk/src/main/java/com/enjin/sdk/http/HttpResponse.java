package com.enjin.sdk.http;

import lombok.ToString;

/**
 * An http response wrapper.
 *
 * @param <T> the type of the body.
 *
 * @author Evan Lindsay
 */
@ToString
public class HttpResponse<T> {

    private int code;
    private T body;

    /**
     * Creates a new http response with the code returned
     * by the destination and the deserialized body.
     *
     * @param code the response code.
     * @param body the response body.
     */
    public HttpResponse(int code, T body) {
        this.code = code;
        this.body = body;
    }

    /**
     * The code returned by the destination.
     *
     * @return the code.
     */
    public int code() {
        return code;
    }

    /**
     * The deserialized body returned by the destination.
     *
     * @return the body.
     */
    public T body() {
        return body;
    }

    /**
     * True is the code is in the range [200-300).
     *
     * @return true if 2xx, else false.
     */
    public boolean isSuccess() {
        return code >= 200 && code < 300;
    }

    /**
     * Returns whether or not there exists a body or not.
     *
     * @return true if there is no body, else false.
     */
    public boolean isEmpty() {
        return this.body == null;
    }
}
