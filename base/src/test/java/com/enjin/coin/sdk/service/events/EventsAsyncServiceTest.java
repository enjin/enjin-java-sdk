package com.enjin.coin.sdk.service.events;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.impl.EventsAsyncServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventRequestVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventResponseVO;

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

	@SuppressWarnings("unchecked")
	@Test
	public void testGetEvent_Success() throws Exception {
		GetEventRequestVO getEventRequestVO = ImmutableGetEventRequestVO.builder().setEventId("eventId").setAuth("auth")
				.build();

		GetEventResponseVO returnedGetEventResponseVO = ImmutableGetEventResponseVO.builder().build();
		GetEventResponseVO[] returnedGetEventResponseArray = new GetEventResponseVO[] {returnedGetEventResponseVO};

		JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
		PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
		Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(),
				Mockito.isA(Map.class))).thenReturn(returnedGetEventResponseArray);

		eventAsyncService = new EventsAsyncServiceImpl(enjinConfig);
		Future<GetEventResponseVO[]> getEventResponseVO = eventAsyncService.getEventAsync(getEventRequestVO);
		assertThat(getEventResponseVO).isNotNull();
		assertThat(getEventResponseVO.get()).isNotNull();

		PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
		Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(),
				Mockito.anyString(), Mockito.isA(Map.class));
	}
}
