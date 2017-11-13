package com.enjin.coin.sdk.mockServer;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EnjinService;
import com.enjin.coin.sdk.service.IdentitiesService;
import com.enjin.coin.sdk.vo.identity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class IdentitiesServiceTestsAgainstMockServer extends BaseMockServer {

    private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";

    private IdentitiesService identities;

    @Before
    public void init() {
        EnjinConfig enjinConfig = new EnjinConfig();
        enjinConfig.setTrustedPlatformUrl(getURL());
        enjinConfig.setInTestMode(true);
        EnjinService enjinService = new EnjinService(enjinConfig);
        identities = enjinService.getIdentitiesService();
    }

    @Test
    public void testGetIdentity() {

        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        GetIdentityRequestVO getIdentityRequestVO = ImmutableGetIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentity(identityMap)
                .build();
        assertThat(getIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(identities.getIdentity(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getEthereumAddress()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getUuid()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getPlayerName()).isNotEmpty()));
    }

    @Test
    public void testListIdentities() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_damien1", "test_damien1_value");
        identityMap.put("test_damien2", "test_damien2_value");

        String afterIdentityId = "after-1";
        String limit = "limit1";
        boolean linked = false;
        ListIdentitiesRequestVO listIdentitiesRequestVO = ImmutableListIdentitiesRequestVO.builder()
                .setAfterIdentityId(afterIdentityId)
                .setAuth("xxzcxcxz")
                .setLimit(limit)
                .setLinked(linked)
                .setIdentity(identityMap)
                .build();
        assertThat(listIdentitiesRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotNull())
                .satisfies(o -> assertThat(identities.listIdentities(o)).isNotEmpty()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .allSatisfy(i -> assertThat(i).isNotNull()
                                .satisfies(o3 -> assertThat(o3.toString()).isNotEmpty())
                                .satisfies(o3 -> assertThat(o3.getIdentityId()).isNotEmpty())
                                .satisfies(o3 -> assertThat(o3.getEthereumAddress()).isNotEmpty())
                                .satisfies(o3 -> assertThat(o3.getPlayerName()).isNotEmpty())));
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
                .setIdentity(identityMap)
                .build();
        assertThat(createIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identities.createIdentity(o)).isNotNull()
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
                .setIdentity(identityMap)
                .setUpdate(updateMap)
                .build();
        String[] keys = {IDENTITY_ID_KEY, ETHEREUM_ADDRESS_KEY, UUID_KEY};
        assertThat(updateIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identities.updateIdentity(o)).isNotNull()
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
                .setIdentity(identityMap)
                .build();
        assertThat(deleteIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(identities.deleteIdentity(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getResult()).isPresent()
                                .hasValueSatisfying(v -> assertThat(v).isTrue())));
    }

}
