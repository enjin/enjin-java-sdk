package com.enjin.coin.sdk.mockServer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.config.ImmutableConfig;
import com.enjin.coin.sdk.service.EnjinCoinClient;
import com.enjin.coin.sdk.service.identities.IdentitiesService;
import com.enjin.coin.sdk.vo.identity.CreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.DeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.GetIdentityResponseVO;
import com.enjin.coin.sdk.vo.identity.ImmutableCreateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableDeleteIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableGetIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.ImmutableUpdateIdentityRequestVO;
import com.enjin.coin.sdk.vo.identity.UpdateIdentityRequestVO;

public class IdentitiesServiceTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";

    private IdentitiesService identitiesService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(getPlatform())
                .setInTestMode(true)
                .build();
        EnjinCoinClient enjinService = new EnjinCoinClient(enjinConfig);
        identitiesService = enjinService.getIdentitiesService();
    }

    @Test
    public void testGetIdentity() {

        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        GetIdentityRequestVO getIdentityRequestVO = ImmutableGetIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .setAfterIdentityId("123456")
                .setLimit("50")
                .setLinked(true)
                .build();
        assertThat(getIdentityRequestVO).isNotNull()
        .satisfies(o -> assertThat(o.toString()).isNotEmpty());

        GetIdentityResponseVO[] getIdentityResponseVO = identitiesService.getIdentity(getIdentityRequestVO);
        assertThat(getIdentityResponseVO).isNotNull();
        for (GetIdentityResponseVO identityResponseVO: getIdentityResponseVO) {
        	assertThat(identityResponseVO).isNotNull()
                .satisfies(o -> assertThat(identityResponseVO).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getEthereumAddress()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getPlayerName()).isNotEmpty()));
        }
    }

    @Test
    public void testCreateIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        //Test the create identity request
        CreateIdentityRequestVO createIdentityRequestVO = ImmutableCreateIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .build();
        assertThat(createIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identitiesService.createIdentity(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityCode()).isNotEmpty()));
    }

    @Test
    public void testUpdateIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("player_name", null);
        updateMap.put("ethereum_address", "0x1111111111111111111111111111111111111111");

        UpdateIdentityRequestVO updateIdentityRequestVO = ImmutableUpdateIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .setUpdateMap(updateMap)
                .build();
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY};
        assertThat(updateIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identitiesService.updateIdentity(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityMap()).isPresent()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull())));
    }

    @Test
    public void testDeleteIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        // Test the delete identity request
        DeleteIdentityRequestVO deleteIdentityRequestVO = ImmutableDeleteIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .build();
        assertThat(deleteIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identitiesService.deleteIdentity(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getResult()).isPresent()
                                .hasValueSatisfying(v -> assertThat(v).isTrue())));
    }

}
