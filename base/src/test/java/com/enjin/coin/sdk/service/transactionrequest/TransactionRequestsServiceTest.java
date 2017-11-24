package com.enjin.coin.sdk.service.transactionrequest;

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

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.transactionrequests.impl.TransactionRequestsServiceImpl;
import com.enjin.coin.sdk.util.JsonRpcUtils;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCreateTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableGetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableGetTransactionRequestResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TransactionRequestsServiceImpl.class)
public class TransactionRequestsServiceTest {

    TransactionRequestsServiceImpl transactionRequestsService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
    }

    @Test
    public void testContructor() {
        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        assertThat(transactionRequestsService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetTransactionRequest_TransactionRequestVOIsNull() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = null;

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    
    @SuppressWarnings("serial")
	@Test
    public void testGetTransactionRequest_AuthIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AuthIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AppIdIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AppIdIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId((String) null)
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_RecipientMapIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{}})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_RecipientMapIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient((Map<String, Object>)null)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_TypeIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_TypeIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType((String) null)
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AfterTxrIdIdIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AfterTxrIdIdIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId((String) null)
                .setLimit("50")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_LimitIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("")
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_LimitIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit((String) null)
                .setCurrency("23456")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_CurrencyIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_CurrencyIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency((String) null)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }
    
    
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetTransactionRequest_ResponseIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseVO);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }
    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetTransactionRequest_Success() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentity(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipient(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = ImmutableGetTransactionRequestResponseVO.builder().build();
        GetTransactionRequestResponseVO[] returnedGetTransactionRequestResponseArray = new GetTransactionRequestResponseVO[] {returnedGetTransactionRequestResponseVO};
        
        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseArray);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCreateTransactionRequest_CreateTransactionRequestRequestVOIsNull() throws Exception {
        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = null;

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_AuthIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_AuthIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_IdentityMapIsNull() {
        Map<String, Object> listIdentityMap = null;
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_IdentityMapIsEmpty() {
        Map<String, Object> listIdentityMap = new HashMap<>();
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_RecipientMapIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = null;
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_RecipientMapIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("type")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_TypeIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType((String) null)
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_TypeIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("")
                .setIcon("icon")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_IconIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon((String) null)
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_IconIEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("")
                .setTitle("title")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_TitleIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle((String) null)
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_TitleIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle("")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_ValueMapIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = null;

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle("Mineplex: /transfer alice 3 ENJ")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCreateTransactionRequest_ValueMapIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle("Mineplex: /transfer alice 3 ENJ")
                .setValueMap(createValueMap)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateTransactionRequest_NullResponse() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle("Mineplex: /transfer alice 3 ENJ")
                .setValueMap(createValueMap)
                .build();

        CreateTransactionRequestResponseVO returnedCreateTransactionRequestResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateTransactionRequestResponseVO);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateTransactionRequest_Success() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("player_name", "Joe");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("player_name", "Alice");
        Map<String, Object> createValueMap = new HashMap<>();
        createValueMap.put("ENJ", "3000000000000000000");

        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = ImmutableCreateTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setRecipientMap(listRecipientMap)
                .setType("send")
                .setIcon("https://enjincoin.io/images/bubble.png")
                .setTitle("Mineplex: /transfer alice 3 ENJ")
                .setValueMap(createValueMap)
                .build();

        CreateTransactionRequestResponseVO returnedCreateTransactionRequestResponseVO = ImmutableCreateTransactionRequestResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedCreateTransactionRequestResponseVO);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCancelTransactionRequest_CancelTransactionRequestRequestVOIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = null;

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setTxrId("1234")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("")
                .setTxrId("1234")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId((String) null)
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("")
                .build();

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCancelTransactionRequest_NullResponse() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        Boolean response = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isNotPresent());

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCancelTransactionRequest_FalseResponse() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        Boolean response = false;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isFalse()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCancelTransactionRequest_Success() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        Boolean response = true;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);

        transactionRequestsService = new TransactionRequestsServiceImpl(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
