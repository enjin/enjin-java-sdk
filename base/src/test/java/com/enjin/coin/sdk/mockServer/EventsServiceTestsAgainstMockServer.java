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

public class EventsServiceTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";
    private static final String PLAYER_NAME_KEY = "player_name";

    private static final String[] KEYS_ARRAY = {IDENTITY_ID_KEY, PLAYER_NAME_KEY};

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
        Map<String, Object> identityMapParam = new HashMap<>();
        identityMapParam.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");

        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("12345")
                .setAuth("auth")
                .setIdentity(identityMapParam)
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();
        assertThat(getEventRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetEventResponseVO[] getEventResponseVO = eventsService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

       for (GetEventResponseVO eventResponseVO : getEventResponseVO) {

        	 assertThat(eventResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(o.getAppId()).isNotEmpty())
                .satisfies(o -> assertThat(o.getEventId()).isNotEmpty())
                .satisfies(o -> assertThat(o.getEventType()).isNotEmpty())
                .satisfies(o -> assertThat(o.getTimestamp()).isNotEmpty())
                .satisfies(o -> assertThat(o.getData()).isNotEmpty());
        	 
        	 String eventType = eventResponseVO.getEventType().get();
        	 System.out.println("eventType:"+eventType);
        	 Map<String, Object> identityMap = null;
        	 if (eventResponseVO.getData().isPresent() && eventResponseVO.getData().get().getIdentityMap().isPresent()) {
        		 identityMap = eventResponseVO.getData().get().getIdentityMap().get();
        	 }
   
        	 GetEventDataVO eventData = eventResponseVO.getData().get();
        	 
        	 switch (eventType) {
        	 	case "identity_created":
                    String[] ic_map_keys = {IDENTITY_ID_KEY, UUID_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap)
                    .isNotEmpty()
                    .containsKeys(ic_map_keys)
                            .extracting(ic_map_keys).doesNotContainNull();
        	 		break;
        	 	case "identity_linked":
                    String[] il_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap).containsKeys(il_map_keys)
                            .extracting(il_map_keys).doesNotContainNull();
        	 		break;
        	 	case "identity_updated":
                    String[] iu_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap)
                    .isNotEmpty()
                    .containsKeys(iu_map_keys)
                            .extracting(iu_map_keys).doesNotContainNull();
        	 		break;
        	 	case "transaction_request":
                    String[] tr_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap)
                    .isNotEmpty()
                    .containsKeys(tr_map_keys)
                            .extracting(tr_map_keys).doesNotContainNull();
                    Map<String, Object> recipientMap = eventResponseVO.getData().get().getIdentityMap().get();
                    assertThat(recipientMap)
                    .isNotEmpty()
                    .containsKeys(tr_map_keys)
                            .extracting(tr_map_keys).doesNotContainNull();
        	 		break;
        	 	case "balance_updated":
                    String[] bu_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap)
                    .isNotEmpty()
                    .containsKeys(bu_map_keys)
                            .extracting(bu_map_keys).doesNotContainNull();
        	 		break;
        	 	case "balance_melted":
                    String[] bm_map_keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
                    assertThat(identityMap)
                    .isNotEmpty()
                    .containsKeys(bm_map_keys)
                            .extracting(bm_map_keys).doesNotContainNull();
        	 		break;
        	 	case "token_updated":
	               	 assertThat(eventData).isNotNull()
	                 .satisfies(o -> assertThat(o.toString()).isNotEmpty())
	                 .satisfies(o -> assertThat(o.getTokenId()).isNotEmpty())
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
        	 	case "token_created":
	               	 assertThat(eventData).isNotNull()
	                 .satisfies(o -> assertThat(o.toString()).isNotEmpty())
	                 .satisfies(o -> assertThat(o.getTokenId()).isNotEmpty())
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
        	 }
        	 
        	 //TODO: come back to this and map the values in Events.get.response.json
            /*    .satisfies(o -> assertThat(o.getData()).isNotEmpty()
                        .hasValueSatisfying(v -> assertThat(v.getIdentityMap()).isNotEmpty()
                                .hasValueSatisfying(v2 -> assertThat(v2).extracting(KEYS_ARRAY))));*/
       	 }
    }   
}
