package com.enjin.sdk.schemas.project.queries;

import com.enjin.sdk.models.PlayerFilter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GetPlayersTest {

    @Test
    void filter_HasVariable() {
        // Arrange
        final String key = "filter";
        final PlayerFilter expected = createDummyPlayerFilter();
        final GetPlayers request = new GetPlayers();

        // Act
        request.filter(expected);
        PlayerFilter actual = (PlayerFilter) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

    private static PlayerFilter createDummyPlayerFilter() {
        return new PlayerFilter();
    }

}