package com.enjin.coin.sdk.mockServer;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.EventsService;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

public class EventsServiceTestsAgainstMockServer extends BaseMockServer{

	private EventsService events;
	
	private String eventId;	
	private String appId;
	private String auth;
	private String afterEventId;
	private String limit;
	
	@Before
	public void init() {
		int port = wireMockRule.port();
		events = new EventsService("http://localhost:" + port +"/", true);
		eventId = "12345";
		appId   = "12345";
		auth    = "auth";
		afterEventId = "123456";
		limit = "limit1";
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetEvent() {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId(eventId);
		getEventRequestVO.setAuth(auth);
		GetEventResponseVO getEventResponseVO = events.getEvent(getEventRequestVO);
		assertNotNull(getEventResponseVO);
		assertNotNull(getEventResponseVO.getAppId());
		assertNotNull(getEventResponseVO.getEventId());
		assertNotNull(getEventResponseVO.getEventType());
		assertNotNull(getEventResponseVO.getTimestamp());
		assertNotNull(getEventResponseVO.getOtherFields());
		assertNotNull(getEventResponseVO.getData());
		assertNotNull(getEventResponseVO.getData().getOtherFields());
		Map<String, Object> identityMap = (Map<String, Object>) getEventResponseVO.getData().getOtherFields().get("identity");
		assertNotNull(identityMap.get("identity_id"));
		assertNotNull(identityMap.get("ethereum_address"));
		assertNotNull(identityMap.get("uuid"));
		assertNotNull(identityMap.get("player_name"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListIdentities() {		
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId(afterEventId);
		listEventsRequestVO.setAppId(appId);
		listEventsRequestVO.setAuth(auth);
		listEventsRequestVO.setLimit(limit);
		
		ListEventsResponseVO listEventsResponseVOArray = events.listEvents(listEventsRequestVO);

		for (GetEventResponseVO getEventResponseVO : listEventsResponseVOArray.getGetEventsResponseVOArray()) {
			assertNotNull(getEventResponseVO);
			assertNotNull(getEventResponseVO.getAppId());
			assertNotNull(getEventResponseVO.getEventId());
			assertNotNull(getEventResponseVO.getEventType());
			assertNotNull(getEventResponseVO.getTimestamp());
			assertNotNull(getEventResponseVO.getOtherFields());
			assertNotNull(getEventResponseVO.getData());
			assertNotNull(getEventResponseVO.getData().getOtherFields());
			Map<String, Object> identityMap = (Map<String, Object>) getEventResponseVO.getData().getOtherFields().get("identity");

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
				Map<String, Object> recipientMap = (Map<String, Object>) getEventResponseVO.getData().getOtherFields().get("recipient");
				assertNotNull(recipientMap.get("identity_id"));
				assertNotNull(recipientMap.get("ethereum_address"));
				assertNotNull(recipientMap.get("player_name"));
				break;	
			case "balance_updated":
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("balances"));
				break;	
			case "balance_melted":
				assertNotNull(identityMap.get("identity_id"));
				assertNotNull(identityMap.get("ethereum_address"));
				assertNotNull(identityMap.get("player_name"));
				break;		
			case "token_updated":
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("token_id"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("creator"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("adapter"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("name"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("icon"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("totalSupply"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("exchangeRate"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("decimals"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("maxMeltFee"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("meltFee"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("transferable"));
				break;
			case "token_created":
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("token_id"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("creator"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("adapter"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("name"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("icon"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("totalSupply"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("exchangeRate"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("decimals"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("maxMeltFee"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("meltFee"));
				assertNotNull(getEventResponseVO.getData().getOtherFields().get("transferable"));	
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
