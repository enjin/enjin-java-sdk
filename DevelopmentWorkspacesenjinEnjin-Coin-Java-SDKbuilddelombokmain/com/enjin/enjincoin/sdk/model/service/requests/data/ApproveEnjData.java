package com.enjin.enjincoin.sdk.model.service.requests.data;

public class ApproveEnjData {
    private Integer value;

    ApproveEnjData(final Integer value) {
        this.value = value;
    }


    public static class ApproveEnjDataBuilder {
        private Integer value;

        ApproveEnjDataBuilder() {
        }

        public ApproveEnjDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public ApproveEnjData build() {
            return new ApproveEnjData(value);
        }

        @Override
        public String toString() {
            return "ApproveEnjData.ApproveEnjDataBuilder(value=" + this.value + ")";
        }
    }

    public static ApproveEnjDataBuilder builder() {
        return new ApproveEnjDataBuilder();
    }
}
