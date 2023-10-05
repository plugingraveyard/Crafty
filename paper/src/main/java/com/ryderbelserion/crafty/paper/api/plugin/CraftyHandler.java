package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.cluster.bukkit.BukkitPlugin;
import com.ryderbelserion.crafty.api.platforms.Platform;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.common.config.ConfigManager;
import com.ryderbelserion.crafty.common.config.types.PluginConfig;
import com.ryderbelserion.crafty.paper.Crafty;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class CraftyHandler extends CraftyPlugin {

    @NotNull
    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    private BukkitPlugin bukkitPlugin;

    public CraftyHandler(File dataFolder) {
        super(dataFolder, Platform.type.paper);
    }

    public void install() {
        // Enable cluster bukkit api.
        this.bukkitPlugin = new BukkitPlugin(this.plugin);
        this.bukkitPlugin.enable();

        // Enable our api.
        super.enable(this.plugin.getServer());

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

    @Override
    @Nullable
    public String identifyClassLoader(ClassLoader classLoader) throws Exception {
        Class<?> classLoaderClass = Class.forName("org.bukkit.plugin.java.PluginClassLoader");

        if (classLoaderClass.isInstance(classLoader)) {
            return this.plugin.getName();
        }

        return null;
    }

    /**
     * Inherited methods.
     */
    @Override
    @NotNull
    public ConfigManager getConfigManager() {
        return super.getConfigManager();
    }
}