package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Map;

public class IdentityFilter {

    private Map<String, Object> map;

    public IdentityFilter(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getMap() {
        return this.map;
    }
}
