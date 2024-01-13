package me.corecraft.crafty.common.platform;

public interface Sender {

    boolean isPlayer();

    String getName();

    boolean hasPermission(String permission);

}