package com.enjin.coin.sdk.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.transactionrequests.TransactionRequestsService;
import com.enjin.coin.sdk.vo.transactionrequest.CancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.CreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.GetTransactionRequestResponseVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCancelTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableCreateTransactionRequestRequestVO;
import com.enjin.coin.sdk.vo.transactionrequest.ImmutableGetTransactionRequestRequestVO;

public class TransactionRequestsTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String PLAYER_NAME_KEY = "player_name";

    private TransactionRequestsService transactionRequestsService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        transactionRequestsService = enjinService.getTransactionRequestsService();
    }

    @SuppressWarnings("serial")
	@Test
    public void testGetTransactionRequest() {
        
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
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
        String[] value_map_keys = {"ENJ"};
        assertThat(getTransactionRequestRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty());
        
        GetTransactionRequestResponseVO[] getTransactionRequestResponseVO = transactionRequestsService.getTransactionRequest(getTransactionRequestRequestVO);
        assertThat(getTransactionRequestResponseVO).isNotNull();
        
        for (GetTransactionRequestResponseVO transactionRequestDetailsResponseVO : getTransactionRequestResponseVO) {
        	assertThat(transactionRequestDetailsResponseVO).isNotNull()
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
                        .satisfies(o2 -> assertThat(o2.getTitle()).isNotEmpty());
        	//TODO: look at the values
                        /*.satisfies(o2 -> assertThat(o2.getValueMap()).isNotEmpty()
                        		
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(value_map_keys)
                                        .extracting(value_map_keys).doesNotContainNull()));*/
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
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, PLAYER_NAME_KEY};
        String[] value_map_keys = {"ENJ"};
        assertThat(createTransactionRequestRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(transactionRequestsService.createTransactionRequest(o)).isNotNull()
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
                .satisfies(o -> assertThat(transactionRequestsService.cancelTransactionRequest(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getResult()).isPresent()));
    }

}
