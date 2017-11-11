package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EventsService;
import com.enjin.coin.sdk.vo.event.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class EventsServiceTestsAgainstMockServer extends BaseMockServer {

    private EventsService events;

    @Before
    public void init() {
        EnjinConfig enjinConfig = new EnjinConfig();
        enjinConfig.setTrustedPlatformUrl(getURL());
        enjinConfig.setInTestMode(true);
        events = new EventsService(enjinConfig);
    }

    @Test
    public void testGetEvent() {
        GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
        getEventRequestVO.setEventId("12345");
        getEventRequestVO.setAuth("auth");
        GetEventResponseVO getEventResponseVO = events.getEvent(getEventRequestVO);
        assertNotNull(getEventResponseVO);
        assertNotNull(getEventResponseVO.getAppId());
        assertNotNull(getEventResponseVO.getEventId());
        assertNotNull(getEventResponseVO.getEventType());
        assertNotNull(getEventResponseVO.getTimestamp());
        assertNotNull(getEventResponseVO.getData());
        assertNotNull(getEventResponseVO.getData().getIdentityMap());
        Map<String, Object> identityMap = getEventResponseVO.getData().getIdentityMap();
        assertNotNull(identityMap.get("identity_id"));
        assertNotNull(identityMap.get("ethereum_address"));
        assertNotNull(identityMap.get("uuid"));
        assertNotNull(identityMap.get("player_name"));
    }

    @Test
    public void testListIdentities() {
        ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
        listEventsRequestVO.setAfterEventId("123456");
        listEventsRequestVO.setAppId("12345");
        listEventsRequestVO.setAuth("auth");
        listEventsRequestVO.setLimit("limit1");

        ListEventsResponseVO listEventsResponseVOArray = events.listEvents(listEventsRequestVO);

        for (GetEventResponseVO getEventResponseVO : listEventsResponseVOArray.getGetEventsResponseVOArray()) {
            assertNotNull(getEventResponseVO);
            assertNotNull(getEventResponseVO.getAppId());
            assertNotNull(getEventResponseVO.getEventId());
            assertNotNull(getEventResponseVO.getEventType());
            assertNotNull(getEventResponseVO.getTimestamp());
            assertNotNull(getEventResponseVO.getData());
            Map<String, Object> identityMap = (Map<String, Object>) getEventResponseVO.getData().getIdentityMap();

            switch (getEventResponseVO.getEventType()) {
                case "identity_created":
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("uuid"));
                    assertNotNull(identityMap.get("player_name"));
                    break;
                case "identity_linked":
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("ethereum_address"));
                    assertNotNull(identityMap.get("uuid"));
                    assertNotNull(identityMap.get("player_name"));
                    break;
                case "identity_updated":
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("ethereum_address"));
                    assertNotNull(identityMap.get("uuid"));
                    assertNotNull(identityMap.get("player_name"));
                    break;
                case "transaction_request":
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("ethereum_address"));
                    assertNotNull(identityMap.get("player_name"));
                    Map<String, Object> recipientMap = (Map<String, Object>) getEventResponseVO.getData().getRecipientMap();
                    assertNotNull(recipientMap.get("identity_id"));
                    assertNotNull(recipientMap.get("ethereum_address"));
                    assertNotNull(recipientMap.get("player_name"));
                    break;
                case "balance_updated":
                    GetEventDataBalancesVO getEventDataBalancesVO = getEventResponseVO.getData().getGetEventDataBalancesVO()[0];
                    assertNotNull(getEventDataBalancesVO);
                    assertNotNull(getEventDataBalancesVO.getIdentityMap());
                    assertNotNull(getEventDataBalancesVO.getIdentityMap().get("identity_id"));
                    assertNotNull(getEventDataBalancesVO.getIdentityMap().get("ethereum_address"));
                    assertNotNull(getEventDataBalancesVO.getIdentityMap().get("player_name"));
                    assertNotNull(getEventDataBalancesVO.getFromMap());
                    assertNotNull(getEventDataBalancesVO.getFromMap().get("ethereum_address"));
                    assertNotNull(getEventDataBalancesVO.getPendingMap());
                    assertNotNull(getEventDataBalancesVO.getPendingMap().get("ENJ"));
                    assertNotNull(getEventDataBalancesVO.getPendingMap().get("123456"));
                    assertNotNull(getEventDataBalancesVO.getConfirmedMap());
                    assertNotNull(getEventDataBalancesVO.getConfirmedMap().get("234567"));
                    assertNotNull(getEventDataBalancesVO.getConfirmedMap().get("345678"));
                    break;
                case "balance_melted":
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("ethereum_address"));
                    assertNotNull(identityMap.get("player_name"));
                    break;
                case "token_updated":
                    assertNotNull(getEventResponseVO.getData().getTokenId());
                    assertNotNull(getEventResponseVO.getData().getCreator());
                    assertNotNull(getEventResponseVO.getData().getAdapter());
                    assertNotNull(getEventResponseVO.getData().getName());
                    assertNotNull(getEventResponseVO.getData().getIcon());
                    assertNotNull(getEventResponseVO.getData().getTotalSupply());
                    assertNotNull(getEventResponseVO.getData().getExchangeRate());
                    assertNotNull(getEventResponseVO.getData().getDecimals());
                    assertNotNull(getEventResponseVO.getData().getMaxMeltFee());
                    assertNotNull(getEventResponseVO.getData().getMeltFee());
                    assertNotNull(getEventResponseVO.getData().getTransferable());
                    break;
                case "token_created":
                    assertNotNull(getEventResponseVO.getData().getTokenId());
                    assertNotNull(getEventResponseVO.getData().getCreator());
                    assertNotNull(getEventResponseVO.getData().getAdapter());
                    assertNotNull(getEventResponseVO.getData().getName());
                    assertNotNull(getEventResponseVO.getData().getIcon());
                    assertNotNull(getEventResponseVO.getData().getTotalSupply());
                    assertNotNull(getEventResponseVO.getData().getExchangeRate());
                    assertNotNull(getEventResponseVO.getData().getDecimals());
                    assertNotNull(getEventResponseVO.getData().getMaxMeltFee());
                    assertNotNull(getEventResponseVO.getData().getMeltFee());
                    assertNotNull(getEventResponseVO.getData().getTransferable());
                    break;
                default:
                    assertNotNull(identityMap.get("identity_id"));
                    assertNotNull(identityMap.get("ethereum_address"));
                    assertNotNull(identityMap.get("uuid"));
                    assertNotNull(identityMap.get("player_name"));
                    break;
            }


        }
    }


}
