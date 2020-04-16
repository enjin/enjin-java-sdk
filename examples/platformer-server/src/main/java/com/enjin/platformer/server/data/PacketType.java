package com.enjin.platformer.server.data;

import lombok.Getter;

public enum PacketType {

    UNKNOWN(-0x1, Packet.class),
    HANDSHAKE(0x0, PacketInHandshake.class),
    AUTHENTICATED(0x1, PacketOutAuthenticated.class),
    SEND_TOKEN(0x2, PacketInSendToken.class);

    @Getter
    private int id;
    @Getter
    private Class<?> clazz;

    PacketType(int id, Class<? extends Packet> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public static PacketType of(int id) {
        PacketType result = UNKNOWN;

        for (PacketType type : values()) {
            if (type.id == id) {
                result = type;
                break;
            }
        }

        return result;
    }

}
