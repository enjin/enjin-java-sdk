package com.enjin.sdk.models.notification.data;

import com.enjin.sdk.models.token.event.TokenEvent;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

@Getter
@ToString
public class EventData {

    @Nullable
    private String blockNumber;
    @Nullable
    private TokenEvent event;
    @Nullable
    private Object param1;
    @Nullable
    private Object param2;
    @Nullable
    private Object param3;
    @Nullable
    private Object param4;

    @Nullable
    private App app;
    @Nullable
    private Identity identity;
    @Nullable
    private Token token;
    @Nullable
    private Trade trade;
    @Nullable
    private Transaction transaction;
    @Nullable
    private Melt melt;
    @Nullable
    private Mint mint;
    @Nullable
    private Transfer transfer;
    @Nullable
    private User user;
    @Nullable
    private Wallet wallet;

}
