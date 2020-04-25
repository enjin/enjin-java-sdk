package com.enjin.sdk.models.notification.data;

import com.enjin.sdk.models.request.TransactionState;
import com.enjin.sdk.models.request.TransactionType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Transaction {

    private String id;
    private String title;
    private TransactionState state;
    private TransactionType type;
    private String displayType;
    private String hash;
    private String value;

}
