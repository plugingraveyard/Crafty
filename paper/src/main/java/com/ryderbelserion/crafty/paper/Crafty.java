package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.common.CraftyFactory;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private final CraftyFactory factory;

    public Crafty(CraftyFactory factory) {
        this.factory = factory;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        // Disable common factory
        this.factory.disable();
    }
}