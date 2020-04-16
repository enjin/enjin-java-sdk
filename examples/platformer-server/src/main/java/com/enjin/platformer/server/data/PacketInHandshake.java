package com.enjin.platformer.server.data;

import lombok.Getter;

public class PacketInHandshake extends Packet {

    @Getter
    private String name;

}
