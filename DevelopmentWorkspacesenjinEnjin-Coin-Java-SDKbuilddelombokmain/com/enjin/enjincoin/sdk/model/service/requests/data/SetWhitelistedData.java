package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SetWhitelistedData {
    @SerializedName("token_id")
    private String tokenId;
    private String account;
    private String whitelisted;
    private Boolean on;

    SetWhitelistedData(final String tokenId, final String account, final String whitelisted, final Boolean on) {
        this.tokenId = tokenId;
        this.account = account;
        this.whitelisted = whitelisted;
        this.on = on;
    }


    public static class SetWhitelistedDataBuilder {
        private String tokenId;
        private String account;
        private String whitelisted;
        private Boolean on;

        SetWhitelistedDataBuilder() {
        }

        public SetWhitelistedDataBuilder tokenId(final String tokenId) {
            this.tokenId = tokenId;
            return this;
        }

        public SetWhitelistedDataBuilder account(final String account) {
            this.account = account;
            return this;
        }

        public SetWhitelistedDataBuilder whitelisted(final String whitelisted) {
            this.whitelisted = whitelisted;
            return this;
        }

        public SetWhitelistedDataBuilder on(final Boolean on) {
            this.on = on;
            return this;
        }

        public SetWhitelistedData build() {
            return new SetWhitelistedData(tokenId, account, whitelisted, on);
        }

        @Override
        public String toString() {
            return "SetWhitelistedData.SetWhitelistedDataBuilder(tokenId=" + this.tokenId + ", account=" + this.account + ", whitelisted=" + this.whitelisted + ", on=" + this.on + ")";
        }
    }

    public static SetWhitelistedDataBuilder builder() {
        return new SetWhitelistedDataBuilder();
    }
}
