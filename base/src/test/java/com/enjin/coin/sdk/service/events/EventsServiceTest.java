package com.enjin.coin.sdk.service.events;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventsServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventRequestVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsServiceImpl.class)
public class EventsServiceTest {

    EventsServiceImpl eventService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
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
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetEvent_ResponseIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AppIdIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId((String) null)
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AppIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AuthIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AuthIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth((String) null)
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void testGetEvent_IdentityMapIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap((Map) null)
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_IdentityMapIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AfterEventIdIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId((String)null)
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_AfterEventIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_LimitIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit((String) null)
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_LimitIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetEvent_Success() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setLimit("50")
                .build();

		GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
		GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        eventService = new EventsServiceImpl(enjinConfig);
        GetEventResponseVO[] getEventResponseVO = eventService.getEvent(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
}
