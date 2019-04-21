package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public class SetApprovalForAllData {

    private String operator;

    @SerializedName("operator_id")
    private BigInteger operatorId;

    private Boolean approved;

}
