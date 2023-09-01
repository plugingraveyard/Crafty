package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.paper.api.plugin.CraftyLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private CraftyLoader craftyLoader;

    @Override
    public void onEnable() {
        // This must go first!
        this.craftyLoader = new CraftyLoader();
        this.craftyLoader.enable();
    }

    @Override
    public void onDisable() {
        // This must go last!
        this.craftyLoader.disable();
    }
}