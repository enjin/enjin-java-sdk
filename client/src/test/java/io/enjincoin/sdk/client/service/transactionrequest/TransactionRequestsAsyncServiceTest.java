package io.enjincoin.sdk.client.service.transactionrequest;

import io.enjincoin.sdk.client.BaseTestHelper;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsAsyncService;
import io.enjincoin.sdk.client.service.transactionrequests.impl.TransactionRequestsAsyncServiceImpl;
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
@PrepareForTest(TransactionRequestsAsyncServiceImpl.class)
public class TransactionRequestsAsyncServiceTest {

    TransactionRequestsAsyncService transactionRequestsAsyncService;
    Config enjinConfig;

    @Before
    public void setUp() {
        enjinConfig = BaseTestHelper.getEnjinConfig();
    }

    @Test
    public void testContructor() {
        transactionRequestsAsyncService = new TransactionRequestsAsyncServiceImpl(enjinConfig);
        assertThat(transactionRequestsAsyncService).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
    }


    @SuppressWarnings({ "unchecked", "serial" })
    @Test
    public void testGetTransactionRequest_Success() throws Exception {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setIdentityMap(new HashMap<String, Object>() {{
                    put("identity_id", "12345");
                }})
                .setAppId("123")
                .setRecipientMap(new HashMap<String, Object>() {{
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

        transactionRequestsAsyncService = new TransactionRequestsAsyncServiceImpl(enjinConfig);
        CompletableFuture<GetTransactionRequestResponseVO[]> getTransactionRequestResponseCompletableFutureVO = transactionRequestsAsyncService.getTransactionRequestAsync(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseCompletableFutureVO).isNotNull();
        assertThat(getTransactionRequestResponseCompletableFutureVO.get()).isNotNull();

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

        transactionRequestsAsyncService = new TransactionRequestsAsyncServiceImpl(enjinConfig);
        CompletableFuture<CreateTransactionRequestResponseVO> createTransactionRequestResponseCompletableFutureVO = transactionRequestsAsyncService.createTransactionRequestAsync(createTransactionRequestRequestVO);
        assertThat(createTransactionRequestResponseCompletableFutureVO).isNotNull();
        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = createTransactionRequestResponseCompletableFutureVO.get();
        assertThat(createTransactionRequestResponseVO).isNotNull();

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

        transactionRequestsAsyncService = new TransactionRequestsAsyncServiceImpl(enjinConfig);
        CompletableFuture<CancelTransactionRequestResponseVO> cancelTransactionRequestResponseCompletableFutureVO = transactionRequestsAsyncService.cancelTransactionRequestAsync(cancelTransactionRequestRequestVO);
        Assertions.assertThat(cancelTransactionRequestResponseCompletableFutureVO).isNotNull();
        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = cancelTransactionRequestResponseCompletableFutureVO.get();
        assertThat(cancelTransactionRequestResponseVO).isNotNull()
                .satisfies(o -> assertThat(o.getResult()).isPresent()
                        .hasValueSatisfying(v -> assertThat(v).isTrue()));

        PowerMockito.verifyNew(JsonRpcUtils.class, Mockito.times(1)).withNoArguments();
        Mockito.verify(mockJsonRpcUtils, Mockito.times(1)).sendJsonRpcRequest(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.isA(Map.class));
    }

}
