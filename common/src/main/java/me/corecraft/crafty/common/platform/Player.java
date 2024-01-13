package me.corecraft.crafty.common.platform;

import java.util.UUID;

public interface Player extends Sender {

    UUID getUUID();

    void sendActionBar(String value);
}