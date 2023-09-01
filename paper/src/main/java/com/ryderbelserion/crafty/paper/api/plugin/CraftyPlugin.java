package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.cluster.bukkit.BukkitPlugin;
import com.ryderbelserion.cluster.bukkit.api.config.FileManager;
import com.ryderbelserion.crafty.paper.api.CrazyManager;
import com.ryderbelserion.crafty.paper.api.config.ConfigManager;
import com.ryderbelserion.crafty.paper.api.plugin.registry.CraftyRegistry;
import org.jetbrains.annotations.NotNull;

public abstract class CraftyPlugin {

    public abstract @NotNull FileManager getFileManager();

    public abstract @NotNull BukkitPlugin getBukkitPlugin();

    public abstract @NotNull ConfigManager getConfigManager();

    public abstract @NotNull CrazyManager getCrazyManager();

    public void enable() {
        CraftyRegistry.start(this);
    }

    public void disable() {
        CraftyRegistry.stop();
    }
}