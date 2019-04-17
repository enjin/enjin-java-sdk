package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SetApprovalData {
    private String operator;
    @SerializedName("operator_id")
    private Integer operatorId;
    private List<TokenIndexPairData> tokens;
    private Boolean approved;

    SetApprovalData(final String operator, final Integer operatorId, final List<TokenIndexPairData> tokens, final Boolean approved) {
        this.operator = operator;
        this.operatorId = operatorId;
        this.tokens = tokens;
        this.approved = approved;
    }


    public static class SetApprovalDataBuilder {
        private String operator;
        private Integer operatorId;
        private List<TokenIndexPairData> tokens;
        private Boolean approved;

        SetApprovalDataBuilder() {
        }

        public SetApprovalDataBuilder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        public SetApprovalDataBuilder operatorId(final Integer operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public SetApprovalDataBuilder tokens(final List<TokenIndexPairData> tokens) {
            this.tokens = tokens;
            return this;
        }

        public SetApprovalDataBuilder approved(final Boolean approved) {
            this.approved = approved;
            return this;
        }

        public SetApprovalData build() {
            return new SetApprovalData(operator, operatorId, tokens, approved);
        }

        @Override
        public String toString() {
            return "SetApprovalData.SetApprovalDataBuilder(operator=" + this.operator + ", operatorId=" + this.operatorId + ", tokens=" + this.tokens + ", approved=" + this.approved + ")";
        }
    }

    public static SetApprovalDataBuilder builder() {
        return new SetApprovalDataBuilder();
    }
}
