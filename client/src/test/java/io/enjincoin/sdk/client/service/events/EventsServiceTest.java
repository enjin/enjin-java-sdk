package io.enjincoin.sdk.client.service.events;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.impl.EventsServiceImpl;
import io.enjincoin.sdk.client.util.JsonRpcUtils;
import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;
import io.enjincoin.sdk.client.vo.event.ImmutableGetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.ImmutableGetEventResponseVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventsServiceImpl.class)
public class EventsServiceTest {

    private EventsService service;
    private Config config;

    @Before
    public void setUp() {
        this.config = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        this.service = new EventsServiceImpl(this.config);
        assertThat(this.service).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetEvent_GetEventRequestVOIsNull() {
        GetEventRequestVO getEventRequestVO = null;

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetEvent_ResponseIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseVO);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_AppIdIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId((String) null)
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_AppIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_EventIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_AuthIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId((String) null)
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void testGetEvent_IdentityMapIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap((Map) null)
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_IdentityMapIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {
                })
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_AfterEventIdIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId((String) null)
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_AfterEventIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_BeforeEventIdIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId((String) null)
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_BeforeEventIdIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_LimitIsNull() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit((String) null)
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_LimitIsEmpty() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEvent_Success() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        GetEventResponseVO[] getEventResponseVO = this.service.getEventsSync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetEventsAsync_Success() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");
                }})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

        GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
        GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[]{returnedGetEventResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(),
                Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

        this.service = new EventsServiceImpl(this.config);
        CompletableFuture<GetEventResponseVO[]> getEventResponseVO = this.service.getEventsAsync(getEventRequestVO);
        assertThat(getEventResponseVO).isNotNull();
        assertThat(getEventResponseVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),
                Mockito.anyString(), Mockito.isA(Map.class));
    }

}
