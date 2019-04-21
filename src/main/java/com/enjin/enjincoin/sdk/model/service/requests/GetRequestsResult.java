package com.enjin.enjincoin.sdk.model.service.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class GetRequestsResult {

    @SerializedName("EnjinTransactions")
    private List<Transaction> requests;

}
