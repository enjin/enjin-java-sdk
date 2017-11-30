package com.enjin.coin.sdk.service.identities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.enjin.coin.sdk.BaseTestHelper;
import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.identities.impl.IdentitiesAsyncServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.CreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableCreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableCreateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableDeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableGetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableGetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableUpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableUpdateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdentitiesAsyncServiceImpl.class)
public class IdentitiesAsyncServiceTest {

    IdentitiesAsyncService identitiesAsyncService;
    Config enjinConfig;


    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        assertThat(identitiesAsyncService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }


    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetIdentity_Success() throws Exception {
        GetIdentityRequestVO getIdentityRequestVO = ImmutableGetIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .setAfterIdentityId("1234567")
                .setLinked(true)
                .setLimit("50")
                .build();

        GetIdentityResponseVO returnedGetIdentityResponseVO = ImmutableGetIdentityResponseVO.builder().build();
        GetIdentityResponseVO[] returnedGetIdentityResponseArray = new GetIdentityResponseVO[] {returnedGetIdentityResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetIdentityResponseArray);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        CompletableFuture<GetIdentityResponseVO[]> getIdentityResponseCompletableFutureVO = identitiesAsyncService.getIdentityAsync(getIdentityRequestVO);
        assertThat(getIdentityResponseCompletableFutureVO).isNotNull();
        assertThat(getIdentityResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }



    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testCreateIdentity_Success() throws Exception {
        CreateIdentityRequestVO createIdentityRequestVO = ImmutableCreateIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        CreateIdentityResponseVO returnedCreateIdentityResponseVO = ImmutableCreateIdentityResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateIdentityResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        CompletableFuture<CreateIdentityResponseVO> createIdentityResponseCompletableFutureVO = identitiesAsyncService.createIdentityAsync(createIdentityRequestVO);
        assertThat(createIdentityResponseCompletableFutureVO).isNotNull();
        CreateIdentityResponseVO createIdentityResponseVO = createIdentityResponseCompletableFutureVO.get();
        assertThat(createIdentityResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testUpdateIdentity_Success() throws Exception {
        UpdateIdentityRequestVO updateIdentityRequestVO = ImmutableUpdateIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .setUpdateMap(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        UpdateIdentityResponseVO returnedUpdateIdentityResponseVO = ImmutableUpdateIdentityResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedUpdateIdentityResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        CompletableFuture<UpdateIdentityResponseVO> updateIdentityResponseCompletableFutureVO = identitiesAsyncService.updateIdentityAsync(updateIdentityRequestVO);
        assertThat(updateIdentityResponseCompletableFutureVO).isNotNull();
        UpdateIdentityResponseVO updateIdentityResponseVO = updateIdentityResponseCompletableFutureVO.get();
        assertThat(updateIdentityResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }


    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testDeleteIdentity_Success() throws Exception {
        DeleteIdentityRequestVO deleteIdentityRequestVO = ImmutableDeleteIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        Boolean result = true;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(result);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        CompletableFuture<DeleteIdentityResponseVO> deleteIdentityResponseCompletableFutureVO = identitiesAsyncService.deleteIdentityAsync(deleteIdentityRequestVO);
        assertThat(deleteIdentityResponseCompletableFutureVO).isNotNull();
        DeleteIdentityResponseVO deleteIdentityResponseVO = deleteIdentityResponseCompletableFutureVO.get();
        assertThat(deleteIdentityResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
