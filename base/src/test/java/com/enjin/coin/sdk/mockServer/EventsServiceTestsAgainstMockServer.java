package com.enjin.coin.sdk.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.vo.event.GetEventDetailsResponseVO;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventRequestVO;

public class EventsServiceTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";
    private static final String PLAYER_NAME_KEY = "player_name";

    private static final String[] KEYS_ARRAY = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY, PLAYER_NAME_KEY};

    private EventsService eventsService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        eventsService = enjinService.getEventsService();
    }

    @Test
    public void testGetEvent() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");

        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("12345")
                .setAuth("auth")
                .setIdentity(identityMap)
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();
        assertThat(getEventRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetEventResponseVO getEventResponseVO = eventsService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();
        assertThat(getEventResponseVO.eventDetailsResponseVOArray()).isNotNull();

        for (GetEventDetailsResponseVO eventDetailsResponseVO : getEventResponseVO.eventDetailsResponseVOArray().get()) {
        	 assertThat(eventDetailsResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getAppId()).isNotEmpty())
                .satisfies(o -> assertThat(o.getEventId()).isNotEmpty())
                .satisfies(o -> assertThat(o.getEventType()).isNotEmpty())
                .satisfies(o -> assertThat(o.getTimestamp()).isNotEmpty())
                .satisfies(o -> assertThat(o.getData()).isNotEmpty()
                        .hasValueSatisfying(v -> assertThat(v.getIdentityMap()).isNotEmpty()
                                .hasValueSatisfying(v2 -> assertThat(v2).extracting(KEYS_ARRAY)
                                        .doesNotContainNull())));
        }
    }   
}
