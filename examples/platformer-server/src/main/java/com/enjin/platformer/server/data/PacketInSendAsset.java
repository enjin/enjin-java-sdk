package com.enjin.platformer.server.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class PacketInSendAsset extends Packet {

    private String asset;
    private int amount;
    @SerializedName("recipient_wallet")
    private String recipientWallet;

}
