package com.enjin.sdk.utils;

import static com.enjin.sdk.utils.FutureUtil.failedFuture;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;

class FutureUtilTest {

    @Test
    void failedFuture_ReturnsFutureWithException() {
        // Act
        Future<Void> future = failedFuture(new Exception());

        // Assert
        assertThrows(Exception.class, future::get);
    }

}