package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BatchApproveData {
    private String operator;
    @SerializedName("operator_id")
    private Integer operatorId;
    private List<ApproveItemDescData> approve;

    BatchApproveData(final String operator, final Integer operatorId, final List<ApproveItemDescData> approve) {
        this.operator = operator;
        this.operatorId = operatorId;
        this.approve = approve;
    }


    public static class BatchApproveDataBuilder {
        private String operator;
        private Integer operatorId;
        private List<ApproveItemDescData> approve;

        BatchApproveDataBuilder() {
        }

        public BatchApproveDataBuilder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        public BatchApproveDataBuilder operatorId(final Integer operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public BatchApproveDataBuilder approve(final List<ApproveItemDescData> approve) {
            this.approve = approve;
            return this;
        }

        public BatchApproveData build() {
            return new BatchApproveData(operator, operatorId, approve);
        }

        @Override
        public String toString() {
            return "BatchApproveData.BatchApproveDataBuilder(operator=" + this.operator + ", operatorId=" + this.operatorId + ", approve=" + this.approve + ")";
        }
    }

    public static BatchApproveDataBuilder builder() {
        return new BatchApproveDataBuilder();
    }
}
