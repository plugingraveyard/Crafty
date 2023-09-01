package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.cluster.bukkit.BukkitPlugin;
import com.ryderbelserion.cluster.bukkit.api.config.FileManager;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.CrazyManager;
import com.ryderbelserion.crafty.paper.api.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader extends CraftyPlugin {

    private @NotNull final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    private BukkitPlugin bukkitPlugin;
    private ConfigManager configManager;
    private FileManager fileManager;
    private CrazyManager crazyManager;

    @Override
    public void enable() {
        super.enable();

        // This must go first.
        this.bukkitPlugin = new BukkitPlugin(this.plugin);
        this.bukkitPlugin.enable();

        // Loads the configurations.
        this.configManager = new ConfigManager();
        this.configManager.load();

        // Creates the file manager.
        this.fileManager = new FileManager();

        // Runs other plugin related code.
        this.crazyManager = new CrazyManager();
        this.crazyManager.load(true);
    }

    @Override
    public void disable() {
        super.disable();

        // Stops the server.
        this.crazyManager.reload(true);

        // This must go last.
        this.bukkitPlugin.disable();
    }

    @Override
    public @NotNull FileManager getFileManager() {
        return this.fileManager;
    }

    @Override
    public @NotNull BukkitPlugin getBukkitPlugin() {
        return this.bukkitPlugin;
    }

    @Override
    public @NotNull ConfigManager getConfigManager() {
        return this.configManager;
    }

    @Override
    public @NotNull CrazyManager getCrazyManager() {
        return this.crazyManager;
    }
}