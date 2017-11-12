package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.TransactionRequestsService;
import com.enjin.coin.sdk.vo.transactionrequest.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class TransactionRequestsTestsAgainstMockServer extends BaseMockServer {

    private TransactionRequestsService transactionRequests;

    @Before
    public void init() {
        EnjinConfig enjinConfig = new EnjinConfig();
        enjinConfig.setTrustedPlatformUrl(getURL());
        enjinConfig.setInTestMode(true);
        EnjinService enjinService = new EnjinService(enjinConfig);
        transactionRequests = enjinService.getTransactionRequestsService();
    }

    @Test
    public void testGetTransactionRequest() {
        GetTransactionRequestRequestVO getTransactionRequestRequestVO = ImmutableGetTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();
        assertNotNull(getTransactionRequestRequestVO.toString());

        GetTransactionRequestResponseVO getTransactionRequestResponseVO = transactionRequests.getTransactionRequest(getTransactionRequestRequestVO);
        assertNotNull(getTransactionRequestResponseVO);
        assertNotNull(getTransactionRequestResponseVO.toString());
        assertNotNull(getTransactionRequestResponseVO.getTxrId());
        assertNotNull(getTransactionRequestResponseVO.getIdentityMap());
        assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("identity_id"));
        assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("player_name"));
        assertNotNull(getTransactionRequestResponseVO.getIdentityMap().get("ethereum_address"));
        assertNotNull(getTransactionRequestResponseVO.getRecipientMap());
        assertNotNull(getTransactionRequestResponseVO.getRecipientMap());
        assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("identity_id"));
        assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("player_name"));
        assertNotNull(getTransactionRequestResponseVO.getRecipientMap().get("ethereum_address"));
        assertNotNull(getTransactionRequestResponseVO.getType());
        assertNotNull(getTransactionRequestResponseVO.getIcon());
        assertNotNull(getTransactionRequestResponseVO.getTitle());
        assertNotNull(getTransactionRequestResponseVO.getValueMap());
        assertNotNull(getTransactionRequestResponseVO.getValueMap().get("ENJ"));
    }

    @Test
    public void testListTransactionRequests() {
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
        assertNotNull(listTransactionRequestsRequestVO.toString());

        ListTransactionRequestsResponseVO[] listTransactionRequestsResponseVOArray = transactionRequests.listTransactionRequests(listTransactionRequestsRequestVO);

        for (ListTransactionRequestsResponseVO listTransactionRequestsResponseVO : listTransactionRequestsResponseVOArray) {
            assertNotNull(listTransactionRequestsResponseVO);
            assertNotNull(listTransactionRequestsResponseVO.toString());
            assertNotNull(listTransactionRequestsResponseVO.getTxrId());
            assertNotNull(listTransactionRequestsResponseVO.getIdentityMap());
            assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("identity_id"));
            assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("player_name"));
            assertNotNull(listTransactionRequestsResponseVO.getIdentityMap().get("ethereum_address"));
            assertNotNull(listTransactionRequestsResponseVO.getRecipientMap());
            assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("identity_id"));
            assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("player_name"));
            assertNotNull(listTransactionRequestsResponseVO.getRecipientMap().get("ethereum_address"));
            assertNotNull(listTransactionRequestsResponseVO.getType());
            assertNotNull(listTransactionRequestsResponseVO.getIcon());
            assertNotNull(listTransactionRequestsResponseVO.getTitle());
            assertNotNull(listTransactionRequestsResponseVO.getValueMap());
        }
    }

    @Test
    public void testCreateTransactionRequest() {
        //Test the create identity request

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
        assertNotNull(createTransactionRequestRequestVO.toString());

        CreateTransactionRequestResponseVO createTransactionRequestResponseVO = transactionRequests.createTransactionRequest(createTransactionRequestRequestVO);
        assertNotNull(createTransactionRequestResponseVO);
        assertNotNull(createTransactionRequestResponseVO.toString());
        assertNotNull(createTransactionRequestResponseVO.getTxrId());
        assertNotNull(createTransactionRequestResponseVO.getIdentityMap());
        assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("identity_id"));
        assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("player_name"));
        assertNotNull(createTransactionRequestResponseVO.getIdentityMap().get("ethereum_address"));
        assertNotNull(createTransactionRequestResponseVO.getRecipientMap());
        assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("identity_id"));
        assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("player_name"));
        assertNotNull(createTransactionRequestResponseVO.getRecipientMap().get("ethereum_address"));
        assertNotNull(createTransactionRequestResponseVO.getType());
        assertNotNull(createTransactionRequestResponseVO.getIcon());
        assertNotNull(createTransactionRequestResponseVO.getTitle());
        assertNotNull(createTransactionRequestResponseVO.getValueMap());
        assertNotNull(createTransactionRequestResponseVO.getValueMap().get("ENJ"));
    }

    @Test
    public void testCancelTransactionRequest() {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();
        assertNotNull(cancelTransactionRequestRequestVO.toString());

        CancelTransactionRequestResponseVO cancelTransactionRequestResponseVO = transactionRequests.cancelTransactionRequest(cancelTransactionRequestRequestVO);
        assertNotNull(cancelTransactionRequestResponseVO);
        assertNotNull(cancelTransactionRequestResponseVO.toString());
        assertNotNull(cancelTransactionRequestResponseVO.getResult());
    }


}
