package com.enjin.sdk.schemas.shared.mutations;

import com.enjin.sdk.models.Melt;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MeltTokenTest {

    private static final List<Melt> melts = new ArrayList<>();

    @BeforeAll
    static void setup() {
        melts.add(new Melt());
        melts.add(new Melt());
        melts.add(new Melt());
    }

    @Test
    void melts_HasVariable() {
        // Arrange
        final String key = "melts";
        final Melt[] expected = melts.toArray(new Melt[0]);
        final MeltToken request = new MeltToken();

        // Act
        request.melts(expected);
        Melt[] actual = (Melt[]) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}