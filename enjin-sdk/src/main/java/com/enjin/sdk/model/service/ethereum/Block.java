package com.enjin.sdk.model.service.ethereum;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Block {

    @SerializedName("block")
    private Integer number;

}
