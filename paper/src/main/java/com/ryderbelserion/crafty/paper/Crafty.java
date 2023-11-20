package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.cluster.paper.ClusterFactory;
import com.ryderbelserion.cluster.paper.modules.ModuleLoader;
import com.ryderbelserion.crafty.common.config.Config;
import com.ryderbelserion.crafty.common.managers.ConfigFactory;
import com.ryderbelserion.crafty.paper.api.CrazyHandler;
import com.ryderbelserion.crafty.paper.modules.HitDelayModule;
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

    private ClusterFactory factory;

    @Override
    public void onEnable() {
        this.crazyHandler = new CrazyHandler(this);
        this.crazyHandler.enable();

        this.factory = new ClusterFactory(this, isLogging());

        // Enable modules.
        this.crazyHandler.getModuleLoader().addModule(new HitDelayModule());
    }

    @Override
    public void onDisable() {
        this.crazyHandler.disable();
    }

    public ClusterFactory getFactory() {
        return this.factory;
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
    public ConfigFactory getConfigManager() {
        return this.crazyHandler.getConfigFactory();
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getCommandManager() {
        return this.crazyHandler.getCommandManager().getBukkitCommandManager();
    }

    public boolean isLogging() {
        return this.crazyHandler.getConfigFactory().getConfig().getProperty(Config.verbose_logging);
    }
}