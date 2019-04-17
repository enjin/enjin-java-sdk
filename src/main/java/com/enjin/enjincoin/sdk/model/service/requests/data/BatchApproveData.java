package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.List;

@Builder
public class BatchApproveData {

    private String operator;

    @SerializedName("operator_id")
    private Integer operatorId;

    private List<ApproveItemDescData> approve;

}
