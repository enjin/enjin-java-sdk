package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class SetApprovalForAllData {

    private String operator;

    @SerializedName("operator_id")
    private Integer operatorId;

    private Boolean approved;

}
