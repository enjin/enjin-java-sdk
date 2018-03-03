package io.enjincoin.sdk.client.mockServer;

public class IdentitiesServiceTestsAgainstMockServer extends BaseMockServer {

    /*private static final String IDENTITY_ID_KEY = "identity_id";
    private static final String ETHEREUM_ADDRESS_KEY = "ethereum_address";
    private static final String UUID_KEY = "uuid";

    private SynchronousIdentitiesService identitiesService;

    @Before
    public void init() {
        Config enjinConfig = ImmutableConfig.builder()
                .setTrustedPlatform(this.getPlatform())
                .setInTestMode(true)
                .build();
        ClientImpl enjinService = new ClientImpl(enjinConfig);
        this.identitiesService = enjinService.getIdentitiesService();
    }

    @Test
    public void testGetIdentity() {

        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_user1", "test_user1_value");
        identityMap.put("test_user2", "test_user2_value");

        GetIdentityRequestVO getIdentityRequestVO = ImmutableGetIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .setAfterIdentityId("123456")
                .setLimit("50")
                .setLinked(true)
                .build();
        assertThat(getIdentityRequestVO).isNotNull();
        assertThat(getIdentityRequestVO.toString()).isNotNull();

        GetIdentityResponseVO[] getIdentityResponseVO = this.identitiesService.getIdentitiesSync(getIdentityRequestVO);
        assertThat(getIdentityResponseVO).isNotNull();
        for (GetIdentityResponseVO identityResponseVO : getIdentityResponseVO) {
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
        identityMap.put("test_user1", "test_user1_value");
        identityMap.put("test_user2", "test_user2_value");

        //Test the create identity request
        CreateIdentityRequestVO createIdentityRequestVO = ImmutableCreateIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .build();
        assertThat(createIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(this.identitiesService.createIdentitySync(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityId()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityCode()).isNotEmpty()));
    }

    @Test
    public void testUpdateIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_user1", "test_user1_value");
        identityMap.put("test_user2", "test_user2_value");

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
                .satisfies(o -> assertThat(this.identitiesService.updateIdentitySync(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getIdentityMap()).isPresent()
                                .hasValueSatisfying(v -> assertThat(v).containsKeys(keys)
                                        .extracting(keys).doesNotContainNull())));
    }

    @Test
    public void testDeleteIdentity() {
        Map<String, Object> identityMap = new HashMap<>();
        identityMap.put("identity_id", "123456");
        identityMap.put("test_user1", "test_user1_value");
        identityMap.put("test_user2", "test_user2_value");

        // Test the delete identity request
        DeleteIdentityRequestVO deleteIdentityRequestVO = ImmutableDeleteIdentityRequestVO.builder()
                .setAuth("xxzcxcxz")
                .setIdentityMap(identityMap)
                .build();
        assertThat(deleteIdentityRequestVO).isNotNull()
                .satisfies(o -> assertThat(o.toString()).isNotEmpty())
                .satisfies(o -> assertThat(this.identitiesService.deleteIdentitySync(o)).isNotNull()
                        .satisfies(o2 -> assertThat(o2.toString()).isNotEmpty())
                        .satisfies(o2 -> assertThat(o2.getResult()).isPresent()
                                .hasValueSatisfying(v -> assertThat(v).isTrue())));
    }*/

}
