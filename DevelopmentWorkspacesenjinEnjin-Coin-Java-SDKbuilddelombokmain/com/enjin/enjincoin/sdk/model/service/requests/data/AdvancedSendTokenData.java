package com.enjin.enjincoin.sdk.model.service.requests.data;

import java.util.List;

public class AdvancedSendTokenData {
    private List<TransferData> transfers;
    private Boolean safe;
    private String data;

    AdvancedSendTokenData(final List<TransferData> transfers, final Boolean safe, final String data) {
        this.transfers = transfers;
        this.safe = safe;
        this.data = data;
    }


    public static class AdvancedSendTokenDataBuilder {
        private List<TransferData> transfers;
        private Boolean safe;
        private String data;

        AdvancedSendTokenDataBuilder() {
        }

        public AdvancedSendTokenDataBuilder transfers(final List<TransferData> transfers) {
            this.transfers = transfers;
            return this;
        }

        public AdvancedSendTokenDataBuilder safe(final Boolean safe) {
            this.safe = safe;
            return this;
        }

        public AdvancedSendTokenDataBuilder data(final String data) {
            this.data = data;
            return this;
        }

        public AdvancedSendTokenData build() {
            return new AdvancedSendTokenData(transfers, safe, data);
        }

        @Override
        public String toString() {
            return "AdvancedSendTokenData.AdvancedSendTokenDataBuilder(transfers=" + this.transfers + ", safe=" + this.safe + ", data=" + this.data + ")";
        }
    }

    public static AdvancedSendTokenDataBuilder builder() {
        return new AdvancedSendTokenDataBuilder();
    }
}
