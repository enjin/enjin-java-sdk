package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventsAsyncServiceImpl;
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
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsAsyncServiceImpl.class)
public class EventsAsyncServiceTest {

	EventsAsyncService eventAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
    }

    @Test
    public void testContructor() {
        eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
        assertThat(eventAsyncService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
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

        eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
        Future<GetEventResponseVO> getEventResponseVO = eventAsyncService.getEventAsync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();
        assertThat(getEventResponseVO.get()).isNotNull();

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

        eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
        Future<ListEventsResponseVO> listEventsResponseFutureVO = eventAsyncService.listEventsAsync(listEventsRequestVO);
        assertThat(listEventsResponseFutureVO).isNotNull();
        ListEventsResponseVO listEventsResponseVO = listEventsResponseFutureVO.get();
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

        eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
        Future<ListEventsResponseVO> listEventsResponseFutureVO = eventAsyncService.listEventsAsync(listEventsRequestVO);
        assertThat(listEventsResponseFutureVO).isNotNull();
        ListEventsResponseVO listEventsResponseVO = listEventsResponseFutureVO.get();
        assertThat(listEventsResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getGetEventsResponseVOArray()).isNotEmpty()
                        .hasValueSatisfying(v -> assertThat(v).isNotEmpty().hasSize(2)));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
