package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.common.config.types.PluginConfig;
import com.ryderbelserion.crafty.paper.api.plugin.CraftyHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private CraftyHandler craftyHandler;

    @Override
    public void onEnable() {
        this.craftyHandler = new CraftyHandler(getDataFolder());
        this.craftyHandler.install();
    }

    @Override
    public void onDisable() {
        this.craftyHandler.uninstall();
    }

    public boolean isLogging() {
        return this.craftyHandler.getConfigManager().getPluginConfig().getProperty(PluginConfig.verbose_logging);
    }
}