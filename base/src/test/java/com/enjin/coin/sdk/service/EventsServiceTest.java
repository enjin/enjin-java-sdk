package com.enjin.coin.sdk.service;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.event.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsService.class)
public class EventsServiceTest {

    EventsService eventService;
    EnjinConfig enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new EnjinConfig();
    }

    @Test
    public void testContructor() {
        eventService = new EventsService(enjinConfig);
        assertNotNull(eventService);
        assertNotNull(eventService.toString());
    }


    @Test
    public void testGetEvent_GetEventRequestVOIsNull() {
        GetEventRequestVO getEventRequestVO = null;

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);
    }

    @Test
    public void testGetEvent_EventIsNull() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId(null)
                .setAuth("auth")
                .build();

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);
    }

    @Test
    public void testGetEvent_EventIdIsEmpty() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("")
                .setAuth("auth")
                .build();

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);
    }

    @Test
    public void testGetEvent_AuthIdIsEmpty() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth("")
                .build();

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);
    }

    @Test
    public void testGetEvent_AuthIsNull() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth(null)
                .build();

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetEvent_ResponseIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth("auth")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNull(getEventResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetEvent_Success() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth("auth")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);

        eventService = new EventsService(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertNotNull(getEventResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testListEvents_ListEventsRequestVOIsNull() {
        ListEventsRequestVO listEventsRequestVO = null;

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_AfterEventIdIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId(null)
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_AfterEventIdIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_AppIdIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId(null)
                .setLimit("limit")
                .setAuth("auth")
                .build();
        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_LimitIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("")
                .setAuth("auth")
                .build();
        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_LimitIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit(null)
                .setAuth("auth")
                .build();
        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_AurgIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("")
                .build();
        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @Test
    public void testListEvents_AuthIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth(null)
                .build();
        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListEvents_ResponseIsNull() throws Exception {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        ListEventsResponseVO[] returnedListEventsResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListEvents_ResponseIsEmpty() throws Exception {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[]{};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNull(listEventsResponseVO);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListEvents_Success1() throws Exception {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[]{
                ImmutableGetEventResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNotNull(listEventsResponseVO);
        assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray());
        assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray().length == 1);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListEvents_Success2() throws Exception {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        GetEventResponseVO[] returnedListEventsResponseVO = new GetEventResponseVO[]{
                ImmutableGetEventResponseVO.builder().build(),
                ImmutableGetEventResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListEventsResponseVO);

        eventService = new EventsService(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertNotNull(listEventsResponseVO);
        assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray());
        assertNotNull(listEventsResponseVO.getGetEventsResponseVOArray().length == 2);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
