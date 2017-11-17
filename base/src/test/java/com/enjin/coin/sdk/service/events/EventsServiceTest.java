package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventsServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventRequestVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsServiceImpl.class)
public class EventsServiceTest {

    EventsServiceImpl eventService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
    }

    @Test
    public void testContructor() {
        eventService = new EventsServiceImpl(enjinConfig);
        assertThat(eventService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetEvent_GetEventRequestVOIsNull() {
        GetEventRequestVO getEventRequestVO = null;

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @Test
    public void testGetEvent_EventIsNull() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId((String) null)
                .setAuth("auth")
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @Test
    public void testGetEvent_EventIdIsEmpty() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("")
                .setAuth("auth")
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @Test
    public void testGetEvent_AuthIdIsEmpty() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth("")
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @Test
    public void testGetEvent_AuthIsNull() {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setEventId("eventId")
                .setAuth((String) null)
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
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

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();

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

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testListEvents_ListEventsRequestVOIsNull() {
        ListEventsRequestVO listEventsRequestVO = null;

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_AfterEventIdIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId((String) null)
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_AfterEventIdIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("auth")
                .build();

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_AppIdIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId((String) null)
                .setLimit("limit")
                .setAuth("auth")
                .build();
        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_LimitIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("")
                .setAuth("auth")
                .build();
        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_LimitIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit((String) null)
                .setAuth("auth")
                .build();
        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_AurgIsEmpty() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth("")
                .build();
        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
    }

    @Test
    public void testListEvents_AuthIsNull() {
        ListEventsRequestVO listEventsRequestVO = ImmutableListEventsRequestVO.builder()
                .setAfterEventId("afterEventId")
                .setAppId("appId")
                .setLimit("limit")
                .setAuth((String) null)
                .build();
        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();
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

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();

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

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNull();

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

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getGetEventsResponseVOArray()).isNotEmpty()
                        .hasValueSatisfying(v -> assertThat(v).isNotEmpty().hasSize(1)));

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

        eventService = new EventsServiceImpl(enjinConfig);
        ListEventsResponseVO listEventsResponseVO = eventService.listEvents(listEventsRequestVO);
        assertThat(listEventsResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getGetEventsResponseVOArray()).isNotEmpty()
                        .hasValueSatisfying(v -> assertThat(v).isNotEmpty().hasSize(2)));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
