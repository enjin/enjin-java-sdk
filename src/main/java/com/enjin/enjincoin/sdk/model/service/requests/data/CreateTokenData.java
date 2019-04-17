package com.enjin.enjincoin.sdk.model.service.requests.data;

import com.enjin.enjincoin.sdk.model.service.tokens.TokenSupplyModel;
import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferFeeSettings;
import com.enjin.enjincoin.sdk.model.service.tokens.TokenTransferable;
import lombok.Builder;

@Builder
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

}
