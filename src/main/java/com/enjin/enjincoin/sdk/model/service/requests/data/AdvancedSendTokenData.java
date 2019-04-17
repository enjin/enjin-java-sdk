package com.enjin.enjincoin.sdk.model.service.requests.data;

import lombok.Builder;

import java.util.List;

@Builder
public class AdvancedSendTokenData {

    private List<TransferData> transfers;

    private Boolean safe;

    private String data;

}
