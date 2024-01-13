package me.corecraft.crafty.common;

import me.corecraft.crafty.common.api.CraftyAPI;
import me.corecraft.crafty.common.api.CraftyImpl;

public class Crafty {

    private final CraftyAPI api;

    public Crafty() {
        this.api = new CraftyImpl(this);
    }

    public CraftyAPI getApi() {
        return this.api;
    }
}