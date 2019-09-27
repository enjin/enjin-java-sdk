package com.enjin.enjincoin.sdk.graphql.definitions;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class MethodsTest {

    @Test(expected = UnsupportedOperationException.class)
    public void constructor_unsupported() throws Exception {
        Whitebox.invokeConstructor(Methods.class);
    }

}
