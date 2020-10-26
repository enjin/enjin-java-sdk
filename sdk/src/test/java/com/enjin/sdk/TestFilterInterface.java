package com.enjin.sdk;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
public interface TestFilterInterface {

    List<String> ids = new ArrayList<>();

    @BeforeAll
    static void setup() {
        ids.add("1");
        ids.add("2");
        ids.add("3");
    }

}
