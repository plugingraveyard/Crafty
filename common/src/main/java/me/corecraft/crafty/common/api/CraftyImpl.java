package me.corecraft.crafty.common.api;

import me.corecraft.crafty.common.Crafty;

public class CraftyImpl implements CraftyAPI {

    private final Crafty crafty;

    public CraftyImpl(Crafty crafty) {
        this.crafty = crafty;
    }

    @Override
    public double version() {
        return 0.1;
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void reload() {

    }
}