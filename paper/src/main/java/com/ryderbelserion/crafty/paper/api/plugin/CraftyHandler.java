package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.cluster.bukkit.BukkitPlugin;
import com.ryderbelserion.crafty.api.platforms.Platform;
import com.ryderbelserion.crafty.api.warps.SpawnManager;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.common.config.ConfigManager;
import com.ryderbelserion.crafty.common.config.types.PluginConfig;
import com.ryderbelserion.crafty.paper.Crafty;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class CraftyHandler extends CraftyPlugin {

    @NotNull
    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    private BukkitPlugin bukkitPlugin;

    public CraftyHandler(File dataFolder) {
        super(dataFolder, Platform.type.paper);
    }

    public void install() {
        // Enable our api.
        super.enable(this.plugin.getServer());

        // Enable cluster bukkit api.
        this.bukkitPlugin = new BukkitPlugin(this.plugin, getConfigManager().getPluginConfig().getProperty(PluginConfig.use_minimessage));
        this.bukkitPlugin.enable();

        // Enable metrics.
        boolean metrics = getConfigManager().getPluginConfig().getProperty(PluginConfig.toggle_metrics);

        //this.metrics = new MetricsHandler();
        //if (metrics) this.metrics.start();
    }

    public void uninstall() {
        // Disable our api.
        super.disable();

        // Disable cluster bukkit api.
        this.bukkitPlugin.disable();
    }

    /**
     * Inherited methods.
     */
    @Override
    @NotNull
    public ConfigManager getConfigManager() {
        return super.getConfigManager();
    }

    @Override
    public @NotNull SpawnManager getSpawnManager() {
        return null;
    }
}