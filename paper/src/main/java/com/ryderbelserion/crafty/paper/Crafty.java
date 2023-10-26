package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import com.ryderbelserion.crafty.common.config.PluginConfig;
import com.ryderbelserion.crafty.common.managers.ConfigManager;
import com.ryderbelserion.crafty.paper.api.CrazyHandler;
import com.ryderbelserion.crafty.paper.listeners.GenericAttackSpeedListener;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Crafty extends JavaPlugin {

    private CrazyHandler crazyHandler;

    private PaperPlugin paperPlugin;

    @Override
    public void onEnable() {
        this.paperPlugin = new PaperPlugin(this, true);
        this.paperPlugin.enable();

        this.crazyHandler = new CrazyHandler(this.paperPlugin.getStorageManager(), getDataFolder());
        this.crazyHandler.enable();

        getServer().getPluginManager().registerEvents(new GenericAttackSpeedListener(), this);
    }

    @Override
    public void onDisable() {
        this.crazyHandler.disable();
    }

    @NotNull
    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    @NotNull
    public CrazyHandler getCrazyHandler() {
        return this.crazyHandler;
    }

    @NotNull
    public ConfigManager getConfigManager() {
        return this.crazyHandler.getConfigManager();
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getCommandManager() {
        return this.crazyHandler.getCommandManager().getBukkitCommandManager();
    }

    public boolean isLogging() {
        return this.crazyHandler.getConfigManager().getPluginConfig().getProperty(PluginConfig.verbose_logging);
    }
}