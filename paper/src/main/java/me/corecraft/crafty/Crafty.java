package me.corecraft.crafty;

import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private static Crafty plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static Crafty getPlugin() {
        return plugin;
    }
}