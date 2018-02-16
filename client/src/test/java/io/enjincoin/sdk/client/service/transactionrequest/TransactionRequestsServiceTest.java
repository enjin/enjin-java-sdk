package io.enjincoin.sdk.client.service.transactionrequest;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.transactionrequests.impl.TransactionRequestsServiceImpl;
import io.enjincoin.sdk.client.util.JsonRpcUtils;
import io.enjincoin.sdk.client.vo.transactionrequest.*;
import org.assertj.core.api.Assertions;
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
@PrepareForTest(TransactionRequestsServiceImpl.class)
public class TransactionRequestsServiceTest {

    TransactionRequestsServiceImpl service;
    Config config;

    @Before
    public void setUp() {
        this.config = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        this.service = new TransactionRequestsServiceImpl(this.config);
        assertThat(this.service).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetTransactionRequest_TransactionRequestVOIsNull() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = null;

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AuthIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AuthIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AppIdIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AppIdIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId((String) null)
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_RecipientMapIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_RecipientMapIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap((Map<String, Object>) null)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_TypeIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_TypeIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType((String) null)
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AfterTxrIdIdIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_AfterTxrIdIdIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId((String) null)
                .setLimit("50")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_LimitIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("")
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_LimitIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit((String) null)
                .setCurrency("23456")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_CurrencyIsEmpty() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("serial")
    @Test
    public void testGetTransactionRequest_CurrencyIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("auth")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency((String) null)
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }


    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetTransactionRequest_ResponseIsNull() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetTransactionRequest_Success() throws Exception {

        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = ImmutableGetTransactionRequestResponseVO.builder().build();
        GetTransactionRequestResponseVO[] returnedGetTransactionRequestResponseArray = new GetTransactionRequestResponseVO[]{returnedGetTransactionRequestResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseArray);

        this.service = new TransactionRequestsServiceImpl(this.config);
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = this.service.getTransactionRequestsSync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCreateTransactionRequest_CreateTransactionRequestRequestVOIsNull() throws Exception {
        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = null;

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = this.service.createTransactionRequestSync(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCancelTransactionRequest_CancelTransactionRequestRequestVOIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = null;

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setTxrId("1234")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("")
                .setTxrId("1234")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId((String) null)
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("")
                .build();

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = this.service.cancelTransactionRequestSync(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings({"unchecked", "serial"})
    @Test
    public void testGetTransactionRequestAsync_Success() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
                    this.put("identity_id", "12345");
                }})
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = ImmutableGetTransactionRequestResponseVO.builder().build();
        GetTransactionRequestResponseVO[] returnedGetTransactionRequestResponseArray = new GetTransactionRequestResponseVO[]{returnedGetTransactionRequestResponseVO};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseArray);

        this.service = new TransactionRequestsServiceImpl(this.config);
        CompletableFuture<GetTransactionRequestResponseVO[]> getTransactionRequestResponseCompletableFutureVO = this.service.getTransactionRequestsAsync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseCompletableFutureVO).isNotNull();
        assertThat(getTransactionRequestResponseCompletableFutureVO.get()).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateTransactionRequestAsync_Success() throws Exception {
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

        this.service = new TransactionRequestsServiceImpl(this.config);
        CompletableFuture<CreateTransactionRequestResponseVO> createTransactionRequestResponseCompletableFutureVO = this.service.createTransactionRequestAsync(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseCompletableFutureVO).isNotNull();
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = createTransactionRequestResponseCompletableFutureVO.get();
        assertThat(createTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCancelTransactionRequestAsync_Success() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        Boolean response = true;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(response);

        this.service = new TransactionRequestsServiceImpl(this.config);
        CompletableFuture<CancelTransactionRequestResponseVO> cancelTransactionRequestResponseCompletableFutureVO = this.service.cancelTransactionRequestAsync(cancelTransactionRequestRequestVO);
        Assertions.assertThat(cancelTransactionRequestResponseCompletableFutureVO).isNotNull();
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = cancelTransactionRequestResponseCompletableFutureVO.get();
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
