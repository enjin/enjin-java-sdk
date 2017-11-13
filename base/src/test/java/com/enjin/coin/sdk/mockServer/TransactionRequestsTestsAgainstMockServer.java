package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.TransactionRequestsService;
import com.enjin.coin.sdk.vo.transactionrequest.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TransactionRequestsTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";
    private static final String PLAYER_NAME_KEY = "player_name";

    private static final String[] KEYS_ARRAY = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY, PLAYER_NAME_KEY};

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
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
        String[] value_map_keys = {"ENJ"};
        assertThat(getTransactionRequestRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(transactionRequests.getTransactionRequest(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTxrId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull()))
                        .satisfies(o2 -> assertThat(o2.getRecipientMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull()))
                        .satisfies(o2 -> assertThat(o2.getType()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIcon()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTitle()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getValueMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(value_map_keys)
                                        .extracting(value_map_keys).doesNotContainNull())));
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
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
        assertThat(listTransactionRequestsRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(transactionRequests.listTransactionRequests(o)).isNotNull()
                        .allSatisfy(i -> assertThat(i).isNotNull()
                                .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                                .satisfies(o2 -> assertThat(o2.getTxrId()).isNotEmpty())
                                .satisfies(o2 -> assertThat(o2.getIdentityMap()).isNotEmpty()
                                        .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                                .extracting(keys).doesNotContainNull()))
                                .satisfies(o2 -> assertThat(o2.getRecipientMap()).isNotEmpty()
                                        .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                                .extracting(keys).doesNotContainNull()))
                                .satisfies(o2 -> assertThat(o2.getType()).isNotEmpty())
                                .satisfies(o2 -> assertThat(o2.getIcon()).isNotEmpty())
                                .satisfies(o2 -> assertThat(o2.getTitle()).isNotEmpty())
                                .satisfies(o2 -> assertThat(o2.getValueMap()).isNotEmpty())));
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
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
        String[] value_map_keys = {"ENJ"};
        assertThat(createTransactionRequestRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(transactionRequests.createTransactionRequest(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTxrId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull()))
                        .satisfies(o2 -> assertThat(o2.getRecipientMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull()))
                        .satisfies(o2 -> assertThat(o2.getType()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIcon()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getTitle()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getValueMap()).isNotEmpty()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(value_map_keys)
                                        .extracting(value_map_keys).doesNotContainNull())));
    }

    @Test
    public void testCancelTransactionRequest() {
        CancelTransactionRequestRequestVO cancelTransactionRequestRequestVO = ImmutableCancelTransactionRequestRequestVO.builder()
                .setAuth("xxxxxxxx")
                .setTxrId("123456")
                .build();
        assertThat(cancelTransactionRequestRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(transactionRequests.cancelTransactionRequest(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getResult()).isPresent()));
    }

}
