package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.enjin.enjincoin.sdk.model.service.tokens.TokenSupplyModel;
import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferable;

public class CreateTokenData {
    private String name;
    private Integer totalSupply;
    private Integer initialReserve;
    private TokenSupplyModel supplyModel;
    private String meltValue;
    private Integer meltFeeRatio;
    private TokenTransferable transferable;
    private TokenTransferFeeSettings transferFeeSettings;
    private Boolean nonFungible;

    CreateTokenData(final String name, final Integer totalSupply, final Integer initialReserve, final TokenSupplyModel supplyModel, final String meltValue, final Integer meltFeeRatio, final TokenTransferable transferable, final TokenTransferFeeSettings transferFeeSettings, final Boolean nonFungible) {
        this.name = name;
        this.totalSupply = totalSupply;
        this.initialReserve = initialReserve;
        this.supplyModel = supplyModel;
        this.meltValue = meltValue;
        this.meltFeeRatio = meltFeeRatio;
        this.transferable = transferable;
        this.transferFeeSettings = transferFeeSettings;
        this.nonFungible = nonFungible;
    }


    public static class CreateTokenDataBuilder {
        private String name;
        private Integer totalSupply;
        private Integer initialReserve;
        private TokenSupplyModel supplyModel;
        private String meltValue;
        private Integer meltFeeRatio;
        private TokenTransferable transferable;
        private TokenTransferFeeSettings transferFeeSettings;
        private Boolean nonFungible;

        CreateTokenDataBuilder() {
        }

        public CreateTokenDataBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public CreateTokenDataBuilder totalSupply(final Integer totalSupply) {
            this.totalSupply = totalSupply;
            return this;
        }

        public CreateTokenDataBuilder initialReserve(final Integer initialReserve) {
            this.initialReserve = initialReserve;
            return this;
        }

        public CreateTokenDataBuilder supplyModel(final TokenSupplyModel supplyModel) {
            this.supplyModel = supplyModel;
            return this;
        }

        public CreateTokenDataBuilder meltValue(final String meltValue) {
            this.meltValue = meltValue;
            return this;
        }

        public CreateTokenDataBuilder meltFeeRatio(final Integer meltFeeRatio) {
            this.meltFeeRatio = meltFeeRatio;
            return this;
        }

        public CreateTokenDataBuilder transferable(final TokenTransferable transferable) {
            this.transferable = transferable;
            return this;
        }

        public CreateTokenDataBuilder transferFeeSettings(final TokenTransferFeeSettings transferFeeSettings) {
            this.transferFeeSettings = transferFeeSettings;
            return this;
        }

        public CreateTokenDataBuilder nonFungible(final Boolean nonFungible) {
            this.nonFungible = nonFungible;
            return this;
        }

        public CreateTokenData build() {
            return new CreateTokenData(name, totalSupply, initialReserve, supplyModel, meltValue, meltFeeRatio, transferable, transferFeeSettings, nonFungible);
        }

        @Override
        public String toString() {
            return "CreateTokenData.CreateTokenDataBuilder(name=" + this.name + ", totalSupply=" + this.totalSupply + ", initialReserve=" + this.initialReserve + ", supplyModel=" + this.supplyModel + ", meltValue=" + this.meltValue + ", meltFeeRatio=" + this.meltFeeRatio + ", transferable=" + this.transferable + ", transferFeeSettings=" + this.transferFeeSettings + ", nonFungible=" + this.nonFungible + ")";
        }
    }

    public static CreateTokenDataBuilder builder() {
        return new CreateTokenDataBuilder();
    }
}
