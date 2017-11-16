package com.enjin.coin.sdk.service.identities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
import com.enjin.coin.sdk.vo.identity.ImmutableListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableListIdentitiesResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableUpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableUpdateIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesRequestVO;
import com.enjin.coin.sdk.vo.identity.ListIdentitiesResponseVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdentitiesAsyncServiceImpl.class)
public class IdentitiesAsyncServiceTest {

    IdentitiesAsyncService identitiesAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
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
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        GetIdentityResponseVO returnedGetIdentityResponseVO = ImmutableGetIdentityResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetIdentityResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<GetIdentityResponseVO> getIdentityResponseFutureVO = identitiesAsyncService.getIdentityAsync(getIdentityRequestVO);
        assertThat(getIdentityResponseFutureVO).isNotNull();
        GetIdentityResponseVO getIdentityResponseVO = getIdentityResponseFutureVO.get();
        assertThat(getIdentityResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }


    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testListIdentities_Success1() throws Exception {
        ListIdentitiesRequestVO listIdentitiesRequestVO = ImmutableListIdentitiesRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = new ListIdentitiesResponseVO[]{
                ImmutableListIdentitiesResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<ListIdentitiesResponseVO[]> listIdentitiesResponseFutureVO = identitiesAsyncService.listIdentitiesAsync(listIdentitiesRequestVO);
        assertThat(listIdentitiesResponseFutureVO).isNotNull();
        ListIdentitiesResponseVO[] listIdentitiesResponseVO = listIdentitiesResponseFutureVO.get();
        assertThat(listIdentitiesResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.length).isEqualTo(1));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testListIdentities_Success2() throws Exception {
        ListIdentitiesRequestVO listIdentitiesRequestVO = ImmutableListIdentitiesRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        ListIdentitiesResponseVO[] returnedListIdentitiesResponseVO = new ListIdentitiesResponseVO[]{
                ImmutableListIdentitiesResponseVO.builder().build(),
                ImmutableListIdentitiesResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListIdentitiesResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<ListIdentitiesResponseVO[]> listIdentitiesResponseFutureVO = identitiesAsyncService.listIdentitiesAsync(listIdentitiesRequestVO);
        assertThat(listIdentitiesResponseFutureVO).isNotNull();
        ListIdentitiesResponseVO[] listIdentitiesResponseVO = listIdentitiesResponseFutureVO.get();
        assertThat(listIdentitiesResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.length).isEqualTo(2));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }


    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testCreateIdentity_Success() throws Exception {
        CreateIdentityRequestVO createIdentityRequestVO = ImmutableCreateIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        CreateIdentityResponseVO returnedCreateIdentityResponseVO = ImmutableCreateIdentityResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateIdentityResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<CreateIdentityResponseVO> createIdentityResponseFutureVO = identitiesAsyncService.createIdentityAsync(createIdentityRequestVO);
        assertThat(createIdentityResponseFutureVO).isNotNull();
        CreateIdentityResponseVO createIdentityResponseVO = createIdentityResponseFutureVO.get();
        assertThat(createIdentityResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testUpdateIdentity_Success() throws Exception {
        UpdateIdentityRequestVO updateIdentityRequestVO = ImmutableUpdateIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .setUpdate(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        UpdateIdentityResponseVO returnedUpdateIdentityResponseVO = ImmutableUpdateIdentityResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedUpdateIdentityResponseVO);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<UpdateIdentityResponseVO> updateIdentityResponseFutureVO = identitiesAsyncService.updateIdentityAsync(updateIdentityRequestVO);
        assertThat(updateIdentityResponseFutureVO).isNotNull();
        UpdateIdentityResponseVO updateIdentityResponseVO = updateIdentityResponseFutureVO.get();
        assertThat(updateIdentityResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

   
    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testDeleteIdentity_Success() throws Exception {
        DeleteIdentityRequestVO deleteIdentityRequestVO = ImmutableDeleteIdentityRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("key", "value");
                }})
                .build();

        Boolean result = true;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(result);

        identitiesAsyncService = new IdentitiesAsyncServiceImpl(enjinConfig);
        Future<DeleteIdentityResponseVO> deleteIdentityResponseFutureVO = identitiesAsyncService.deleteIdentityAsync(deleteIdentityRequestVO);
        assertThat(deleteIdentityResponseFutureVO).isNotNull();
        DeleteIdentityResponseVO deleteIdentityResponseVO = deleteIdentityResponseFutureVO.get();
        assertThat(deleteIdentityResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
