package me.corecraft.crafty.loader;

import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.api.ApiLoader;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import us.crazycrew.crazycore.CrazyLogger;
import us.crazycrew.crazycore.paper.PaperConsole;
import us.crazycrew.crazycore.paper.PaperCore;
import java.util.logging.LogManager;

public class CraftyStarter implements PluginBootstrap {

    private PaperCore paperCore;
    private ApiLoader apiLoader;

    @Override
    public void bootstrap(@NotNull PluginProviderContext context) {
        this.paperCore = new PaperCore(context.getConfiguration().getName(), context.getDataDirectory());

        this.apiLoader = new ApiLoader(context.getDataDirectory());

        apiLoader.load();
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        this.paperCore.setConsole(new PaperConsole());

        this.paperCore.setPrefix(this.apiLoader.getPluginSettings().getProperty(PluginSettings.CONSOLE_PREFIX));

        CrazyLogger.setName(this.paperCore.getProjectName());

        LogManager.getLogManager().addLogger(CrazyLogger.getLogger());

        return new Crafty(this.paperCore, this.apiLoader);
    }
}