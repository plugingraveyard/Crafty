package com.ryderbelserion.crafty;

import com.ryderbelserion.crafty.api.ApiLoader;
import com.ryderbelserion.crafty.api.enums.Permissions;
import com.ryderbelserion.crafty.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import us.crazycrew.crazycore.CrazyLogger;
import us.crazycrew.crazycore.paper.PaperCore;
import java.util.logging.Logger;

public class Crafty extends JavaPlugin {

    private static Crafty plugin;

    private final PaperCore paperCore;
    private final ApiLoader apiLoader;

    public Crafty(PaperCore paperCore, ApiLoader apiLoader) {
        this.paperCore = paperCore;

        this.apiLoader = apiLoader;
    }

    @Override
    public @NotNull Logger getLogger() {
        return CrazyLogger.getLogger();
    }

    @Override
    public void onEnable() {
        plugin = this;

        Permissions.setup(getServer().getPluginManager());

        CommandManager commandManager = new CommandManager();

        commandManager.setup();
    }

    @Override
    public void onDisable() {

    }

    public PaperCore getPaperCore() {
        return this.paperCore;
    }

    public ApiLoader getApiLoader() {
        return this.apiLoader;
    }

    public static Crafty getPlugin() {
        return plugin;
    }
}