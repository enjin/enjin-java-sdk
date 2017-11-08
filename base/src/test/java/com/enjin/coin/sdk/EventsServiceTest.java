package com.enjin.coin.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsService.class)
public class EventsServiceTest {

	EventsService eventService;

	@Test
	public void testContructor1() {
		eventService = new EventsService();
		assertNotNull(eventService);
		assertNotNull(eventService.toString());
	}
	
	@Test
	public void testContructor2() {
		eventService = new EventsService("http://localhost:8080");
		assertNotNull(eventService);
		assertNotNull(eventService.toString());
	}
	@Test
	public void testContructor3() {
		eventService = new EventsService("http://localhost:8080", false);
		assertNotNull(eventService);
		assertNotNull(eventService.toString());
	}
	@Test
	public void testContructor4() {
		eventService = new EventsService(false);
		assertNotNull(eventService);
		assertNotNull(eventService.toString());
	}
	@Test
	public void testGetEvent_GetEventRequestVOIsNull() {
		GetEventRequestVO getEventRequestVO = null;
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
	}
	@Test
	public void testGetEvent_EventIsNull() {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId(null);
		getEventRequestVO.setAuth("auth");
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
	}
	@Test
	public void testGetEvent_EventIdIsEmpty() {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId("");
		getEventRequestVO.setAuth("auth");
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
	}
	@Test
	public void testGetEvent_AuthIdIsEmpty() {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId("eventId");
		getEventRequestVO.setAuth("");
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
	}
	@Test
	public void testGetEvent_AuthIsNull() {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId("eventId");
		getEventRequestVO.setAuth(null);
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
	}

	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetEvent_ResponseIsNull() throws Exception {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId("eventId");
		getEventRequestVO.setAuth("auth");
		
		GetEventResponseVO returnedGetEventResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNull(getEventResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetEvent_Success() throws Exception {
		GetEventRequestVO getEventRequestVO = new GetEventRequestVO();
		getEventRequestVO.setEventId("eventId");
		getEventRequestVO.setAuth("auth");

		GetEventResponseVO returnedGetEventResponseVO = new GetEventResponseVO();
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);
		
		eventService = new EventsService();
		GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
		assertNotNull(getEventResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
	@Test
	public void testListEvents_ListEventsRequestVOIsNull() {
		ListEventsRequestVO listEventsRequestVO = null;
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_AfterEventIdIsNull() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId(null);
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_AfterEventIdIsEmpty() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_AppIdIsNull() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId(null);
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_LimitIsEmpty() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("");
		listEventsRequestVO.setAuth("auth");
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_LimitIsNull() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit(null);
		listEventsRequestVO.setAuth("auth");
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_AurgIsEmpty() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("");
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@Test
	public void testListEvents_AuthIsNull() {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth(null);
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListEvents_ResponseIsNull() throws Exception {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		ListEventsResponseVO[] returnedListEventsResponseVO = null;
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListEvents_ResponseIsEmpty() throws Exception {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[] {};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNull(listEventsResponseVO);

		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListEvents_Success1() throws Exception {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[] {new GetEventResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNotNull(listEventsResponseVO);
		assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray());
		assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray().length == 1);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testListEvents_Success2() throws Exception {
		ListEventsRequestVO listEventsRequestVO = new ListEventsRequestVO();
		listEventsRequestVO.setAfterEventId("afterEventId");
		listEventsRequestVO.setAppId("appId");
		listEventsRequestVO.setLimit("limit");
		listEventsRequestVO.setAuth("auth");
		
		GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[] {new GetEventResponseVO(), new GetEventResponseVO()};
		
		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);
		
		eventService = new EventsService();
		ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
		assertNotNull(listEventsResponseVO);
		assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray());
		assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray().length == 2);
		
		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),  Mockito.anyString(), Mockito.isA(Map.class));
	}
	
}
