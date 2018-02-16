package io.enjincoin.sdk.client.service.events;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.impl.EventsAsyncServiceImpl;
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
@PrepareForTest(EventsAsyncServiceImpl.class)
public class EventsAsyncServiceTest {

	EventsAsyncService eventAsyncService;
	Config enjinConfig;


    @Before
	public void setUp() {
	    enjinConfig = BaseTestHelper.getEnjinConfig();
	}

	@Test
	public void testContructor() {
		eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
		assertThat(eventAsyncService).isNotNull().satisfies(o -> assertThat(o.toString()).isNotEmpty());
	}

	@SuppressWarnings({ "unchecked", "serial" })
	@Test
	public void testGetEvent_Success() throws Exception {
        GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder()
                .setAppId("eventId")
                .setEventId("eventId")
                .setIdentityMap(new HashMap<String, Object>() {{put("uuid", "069a79f4-44e9-4726-a5be-fca90e38aaf5");}})
                .setAfterEventId("123456789")
                .setBeforeEventId("123456789")
                .setLimit("50")
                .build();

		GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
		GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(),
				Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

		eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
		CompletableFuture<GetEventResponseVO[]> getEventResponseVO = eventAsyncService.getEventAsync(getEventRequestVO);
		assertThat(getEventResponseVO).isNotNull();
		assertThat(getEventResponseVO.get()).isNotNull();

		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),
				Mockito.anyString(), Mockito.isA(Map.class));
	}
}
