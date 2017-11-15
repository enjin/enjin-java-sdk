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
import com.enjin.coin.sdk.vo.event.GetEventDataVO;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventRequestVO;
import com.enjin.coin.sdk.vo.event.ImmutableListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

public class EventsServiceTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";
    private static final String PLAYER_NAME_KEY = "player_name";

    private static final String[] KEYS_ARRAY = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY, PLAYER_NAME_KEY};

    private EventsService events;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        events = enjinService.getEventsService();
    }

    @Test
    public void testGetEvent() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("12345")
                .setAuth("auth")
                .build();
        assertThat(getEventRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetEventResponseVO getEventResponseVO = events.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull()
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

    @Test
    public void testListIdentities() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("123456")
                .setAppId("12345")
                .setLimit("limit1")
                .setAuth("auth")
                .build();
        assertThat(listEventsRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        ListEventsResponseVO listEventsResponseVOArray = events.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVOArray).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getGetEventsResponseVOArray()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).doesNotContainNull()));

        for (GetEventResponseVO getEventResponseVO : listEventsResponseVOArray.getGetEventsResponseVOArray().orElse(new GetEventResponseVO[]{})) {
            assertThat(getEventResponseVO).isNotNull()
                    .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                    .satisfies(o -> assertThat(o.getAppId()).isNotEmpty())
                    .satisfies(o -> assertThat(o.getEventId()).isNotEmpty())
                    .satisfies(o -> assertThat(o.getEventType()).isNotEmpty())
                    .satisfies(o -> assertThat(o.getTimestamp()).isNotEmpty())
                    .satisfies(o -> assertThat(o.getData()).isNotEmpty());

            final String eventType = getEventResponseVO.getEventType().get();
            final GetEventDataVO data = getEventResponseVO.getData().get();
            final Map<String, Object> identityMap = data.getIdentityMap().orElse(new HashMap<>());

            switch (eventType) {
                case "identity_created":
                    String[] ic_map_keys = {IDENTITY_ID_KEY, UUID_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap).containsKeys(ic_map_keys)
                            .extracting(ic_map_keys).doesNotContainNull();
                    break;
                case "transaction_request":
                    String[] tr_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap).containsKeys(tr_map_keys).extracting(tr_map_keys)
                            .doesNotContainNull();
                    assertThat(data.getRecipientMap()).isNotEmpty()
                            .hasValueSatisfying(v -> assertThat(v).containsKeys(tr_map_keys)
                                    .extracting(tr_map_keys).doesNotContainNull());
                    break;
                case "balance_updated":
                    String[] bu_identity_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    String[] bu_from_map_keys = {ETHEREUM_ADDRESS_KEY};
                    String[] bu_pending_map_keys = {"ENJ", "123456"};
                    String[] bu_confirmed_map_keys = {"234567", "345678"};
                    assertThat(data.getGetEventDataBalancesVO()).isNotEmpty()
                            .hasValueSatisfying(v -> {
                                assertThat(v).isNotEmpty().doesNotContainNull();
                                assertThat(v[0]).satisfies(i -> assertThat(i.getIdentityMap()).isNotEmpty()
                                        .hasValueSatisfying(v2 -> assertThat(v2).containsKeys(bu_identity_map_keys)
                                                .extracting(bu_identity_map_keys).doesNotContainNull()))
                                        .satisfies(i -> assertThat(i.getFromMap()).isNotEmpty()
                                                .hasValueSatisfying(v2 -> assertThat(v2).containsKeys(bu_from_map_keys)
                                                        .extracting(bu_from_map_keys).doesNotContainNull()))
                                        .satisfies(i -> assertThat(i.getPendingMap()).isNotEmpty()
                                                .hasValueSatisfying(v2 -> assertThat(v2).containsKeys(bu_pending_map_keys)
                                                        .extracting(bu_pending_map_keys).doesNotContainNull()))
                                        .satisfies(i -> assertThat(i.getConfirmedMap()).isNotEmpty()
                                                .hasValueSatisfying(v2 -> assertThat(v2).containsKeys(bu_confirmed_map_keys)
                                                        .extracting(bu_confirmed_map_keys).doesNotContainNull()));
                            });
                    break;
                case "balance_melted":
                    String[] bm_identity_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap).containsKeys(bm_identity_map_keys)
                            .extracting(bm_identity_map_keys).doesNotContainNull();
                    break;
                case "token_updated":
                case "token_created":
                    assertThat(data).satisfies(o -> assertThat(o.getTokenId()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getCreator()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getAdapter()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getName()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getIcon()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getTotalSupply()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getExchangeRate()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getDecimals()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getMaxMeltFee()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getMeltFee()).isNotEmpty())
                            .satisfies(o -> assertThat(o.getTransferable()).isNotEmpty());
                    break;
                case "identity_linked":
                case "identity_updated":
                default:
                    assertThat(identityMap).containsKeys(KEYS_ARRAY)
                            .extracting(KEYS_ARRAY).doesNotContainNull();
                    break;
            }

        }
    }

}
