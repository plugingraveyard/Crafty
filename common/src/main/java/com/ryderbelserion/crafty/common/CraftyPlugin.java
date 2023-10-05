package com.ryderbelserion.crafty.common;

import com.ryderbelserion.cluster.api.RootPlugin;
import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.crafty.api.platforms.Platform;
import com.ryderbelserion.crafty.common.api.AbstractPlugin;
import com.ryderbelserion.crafty.common.config.ConfigManager;
import com.ryderbelserion.crafty.common.config.types.PluginConfig;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public abstract class CraftyPlugin extends AbstractPlugin {

    private ConfigManager configManager;

    public CraftyPlugin(File dataFolder, Platform.type platform) {
        super(dataFolder, platform);
    }

    public void enable(Audience audience) {
        super.enablePlugin();

        this.configManager = new ConfigManager(getDataFolder());
        this.configManager.load();

        RootPlugin.setConsole(audience);
        FancyLogger.setName(this.configManager.getPluginConfig().getProperty(PluginConfig.console_prefix));

        super.apiWasLoadedByOurPlugin();
    }

    public void disable() {
        super.disablePlugin();

        this.configManager.reload();
    }

    @Override
    @NotNull
    public ConfigManager getConfigManager() {
        return this.configManager;
    }
}