package com.ryderbelserion.crafty;

import co.aikar.commands.PaperCommandManager;
import com.ryderbelserion.crafty.api.ApiLoader;
import com.ryderbelserion.crafty.api.enums.Permissions;
import com.ryderbelserion.crafty.commands.CraftyBaseCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import us.crazycrew.crazycore.paper.CrazyCore;
import us.crazycrew.crazycore.paper.CrazyLogger;
import java.util.logging.Logger;

public class Crafty extends JavaPlugin {

    private static Crafty plugin;

    private final CrazyCore crazyCore;
    private final ApiLoader apiLoader;

    public Crafty(CrazyCore paperCore, ApiLoader apiLoader) {
        this.crazyCore = paperCore;

        this.apiLoader = apiLoader;
    }

    @Override
    public @NotNull Logger getLogger() {
        return CrazyLogger.getLogger();
    }

    @Override
    public void onEnable() {
        plugin = this;

        // Set up permissions.
        Permissions.setup(getServer().getPluginManager());

        // Set up commands.
        PaperCommandManager manager = new PaperCommandManager(plugin);
        CraftyBaseCommand.setup(manager);
    }

    @Override
    public void onDisable() {

    }

    public CrazyCore getCrazyCore() {
        return this.crazyCore;
    }

    public ApiLoader getApiLoader() {
        return this.apiLoader;
    }

    public static Crafty getPlugin() {
        return plugin;
    }
}