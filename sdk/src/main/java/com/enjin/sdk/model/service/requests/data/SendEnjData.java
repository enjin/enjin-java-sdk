package com.enjin.sdk.model.service.requests.data;

import lombok.Builder;

@Builder
public class SendEnjData {

    private String to;

    private String value;

}
