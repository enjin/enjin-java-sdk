package com.enjin.coin.sdk.config;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableGetEventResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonConfig.class, File.class})
public class JsonConfigTest {

	@Test
	public void testLoad_FileDoesntExist() {
        GetEventResponseVO configClass = ImmutableGetEventResponseVO.builder().build();
		
        File mockFile = PowerMockito.mock(File.class);
        JsonConfig.load(mockFile, configClass);
		
	}
}
