package com.ryderbelserion.crafty.paper;

import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Guten Tag!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Gute Nacht!");
    }
}