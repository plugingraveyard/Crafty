package com.ryderbelserion.crafty.loader;

import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.ApiLoader;
import com.ryderbelserion.crafty.api.configs.types.PluginSettings;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import us.crazycrew.crazycore.paper.CrazyCore;
import us.crazycrew.crazycore.paper.CrazyLogger;
import java.util.logging.LogManager;

public class CraftyStarter implements PluginBootstrap {

    private CrazyCore crazyCore;
    private ApiLoader apiLoader;

    @Override
    public void bootstrap(@NotNull PluginProviderContext context) {
        this.crazyCore = new CrazyCore(context.getDataDirectory(), context.getConfiguration().getName());

        this.apiLoader = new ApiLoader(context.getDataDirectory());

        apiLoader.load();
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        this.crazyCore.setPrefix(this.apiLoader.getPluginSettings().getProperty(PluginSettings.CONSOLE_PREFIX));

        CrazyLogger.setName(CrazyCore.getProjectPrefix());

        LogManager.getLogManager().addLogger(CrazyLogger.getLogger());

        return new Crafty(this.crazyCore, this.apiLoader);
    }
}