package com.enjin.platformer.server.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class PacketInSendToken extends Packet {

    private String token;
    private int amount;
    @SerializedName("recipient_wallet")
    private String recipientWallet;

}
