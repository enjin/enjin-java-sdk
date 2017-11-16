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
import com.enjin.coin.sdk.service.TransactionRequestsService;
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
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableListTransactionRequestsResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ListTransactionRequestsResponseVO;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TransactionRequestsService.class)
public class TransactionRequestsServiceTest {

    TransactionRequestsService transactionRequestsService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = new Config();
    }

    @Test
    public void testContructor() {
        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        assertThat(transactionRequestsService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }

    @Test
    public void testGetTransactionRequest_AuthIsNull() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setTxrId("txrId")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testGetTransactionRequest_AuthIsEmpty() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("")
                .setTxrId("txrId")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testGetTransactionRequest_TxrIdIsNull() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId((String) null)
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testGetTransactionRequest_TxrIdIsEmpty() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("txrId")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetTransactionRequest_ResponseIsNull() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseVO);

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGetTransactionRequest_Success() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();

        GetTransactionRequestResponseVO returnedGetTransactionRequestResponseVO = ImmutableGetTransactionRequestResponseVO.builder().build();

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedGetTransactionRequestResponseVO);

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testListTransactionRequests_ListTransactionRequestsRequestVOIsNull() throws Exception {
        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = null;

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AuthIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("")
                .setIdentityMap(listIdentityMap)
                .setAppId("appId")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AuthIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth((String) null)
                .setIdentityMap(listIdentityMap)
                .setAppId("appId")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_IdentityMaoIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("1233")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_IdentityMaoIsNull() throws Exception {
        Map<String, Object> listIdentityMap = null;
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("1233")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AppIdIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AppIdIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId((String) null)
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_RecipientMapIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_RecipientMapIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = null;

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_TypeIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("")
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_TypeIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType((String) null)
                .setAfterTxrId("after")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AfterTxrIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("")
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_AfterTxrIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId((String) null)
                .setLimit("50")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_LimitIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("")
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_LimitIsNull() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit((String) null)
                .setCurrency("currency")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_CurrencyIsEmpty() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @Test
    public void testListTransactionRequests_CurrencyIsNully() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency((String) null)
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTransactionRequests_NullResponseReturned() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = null;

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTransactionRequests_NoResponseReturned() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = new ListTransactionRequestsResponseVO[]{};

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNotNull().hasSize(0);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListTransactionRequests_Success() throws Exception {
        Map<String, Object> listIdentityMap = new HashMap<>();
        listIdentityMap.put("identity_id", "12345");
        Map<String, Object> listRecipientMap = new HashMap<>();
        listRecipientMap.put("identity_id", "54321");

        ListTransactionRequestsRequestVO listTransactionRequestsRequestVO = ImmutableListTransactionRequestsRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(listIdentityMap)
                .setAppId("123")
                .setRecipientMap(listRecipientMap)
                .setType("buy")
                .setAfterTxrId("1234567")
                .setLimit("50")
                .setCurrency("23456")
                .build();

        ListTransactionRequestsResponseVO[] returnedListTransactionRequestsResponseVOArray = new ListTransactionRequestsResponseVO[]{
                ImmutableListTransactionRequestsResponseVO.builder().build()
        };

        JsonRpcUtils mockJsonRpcUtils = PowerMockito.mock(JsonRpcUtils.class);
        PowerMockito.whenNew(JsonRpcUtils.class).withNoArguments().thenReturn(mockJsonRpcUtils);
        Mockito.when(mockJsonRpcUtils.sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class))).thenReturn(returnedListTransactionRequestsResponseVOArray);

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequestsService.listTransactionRequests(listTransactionRequestsRequestVO);
        assertThat(listTransactionRequestsResponseVOArray).isNotNull().hasSize(1);

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCreateTransactionRequest_CreateTransactionRequestRequestVOIsNull() throws Exception {
        CreateTransactionRequestRequestVO createTransactionRequestRequestVO = null;

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequestsService.createTransactionRequest(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseVO).isNotNull();

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

    @Test
    public void testCancelTransactionRequest_CancelTransactionRequestRequestVOIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = null;

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth((String) null)
                .setTxrId("1234")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_AuthIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("")
                .setTxrId("1234")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsNull() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId((String) null)
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNull();
    }

    @Test
    public void testCancelTransactionRequest_TxrIdIsEmpty() throws Exception {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("")
                .build();

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
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

        transactionRequestsService = new TransactionRequestsService(enjinConfig);
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequestsService.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
