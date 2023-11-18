package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import com.ryderbelserion.crafty.common.config.PluginConfig;
import com.ryderbelserion.crafty.common.managers.ConfigManager;
import com.ryderbelserion.crafty.paper.api.CrazyHandler;
import com.ryderbelserion.crafty.paper.modules.ModuleLoader;
import com.ryderbelserion.crafty.paper.modules.types.HitDelayModule;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Crafty extends JavaPlugin {

    @NotNull
    public static Crafty get() {
        return JavaPlugin.getPlugin(Crafty.class);
    }

    private CrazyHandler crazyHandler;

    private PaperPlugin plugin;

    @Override
    public void onEnable() {
        this.plugin = new PaperPlugin(this, true);
        this.plugin.enable();

        this.crazyHandler = new CrazyHandler(this.plugin.getStorageManager(), getDataFolder());
        this.crazyHandler.enable();

        // Enable modules.
        this.crazyHandler.getModuleLoader().addModule(new HitDelayModule());
    }

    @Override
    public void onDisable() {
        this.crazyHandler.disable();
    }

    @NotNull
    public PaperPlugin getPlugin() {
        return this.plugin;
    }

    @NotNull
    public CrazyHandler getCrazyHandler() {
        return this.crazyHandler;
    }

    @NotNull
    public ModuleLoader getModuleLoader() {
        return this.crazyHandler.getModuleLoader();
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