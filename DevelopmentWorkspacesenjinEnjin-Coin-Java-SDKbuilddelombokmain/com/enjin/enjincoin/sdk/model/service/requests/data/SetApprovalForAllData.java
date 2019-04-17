package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;

public class SetApprovalForAllData {
    private String operator;
    @SerializedName("operator_id")
    private Integer operatorId;
    private Boolean approved;

    SetApprovalForAllData(final String operator, final Integer operatorId, final Boolean approved) {
        this.operator = operator;
        this.operatorId = operatorId;
        this.approved = approved;
    }


    public static class SetApprovalForAllDataBuilder {
        private String operator;
        private Integer operatorId;
        private Boolean approved;

        SetApprovalForAllDataBuilder() {
        }

        public SetApprovalForAllDataBuilder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        public SetApprovalForAllDataBuilder operatorId(final Integer operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public SetApprovalForAllDataBuilder approved(final Boolean approved) {
            this.approved = approved;
            return this;
        }

        public SetApprovalForAllData build() {
            return new SetApprovalForAllData(operator, operatorId, approved);
        }

        @Override
        public String toString() {
            return "SetApprovalForAllData.SetApprovalForAllDataBuilder(operator=" + this.operator + ", operatorId=" + this.operatorId + ", approved=" + this.approved + ")";
        }
    }

    public static SetApprovalForAllDataBuilder builder() {
        return new SetApprovalForAllDataBuilder();
    }
}
