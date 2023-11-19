package com.ryderbelserion.crafty.common;

import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.ICrafty;
import com.ryderbelserion.crafty.common.managers.ConfigManager;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.logging.Logger;

public abstract class CraftyPlugin implements ICrafty {

    private final File dataFolder;
    private final Logger logger;

    public CraftyPlugin(File dataFolder, Logger logger) {
        this.dataFolder = dataFolder;

        this.logger = logger;
    }

    private ConfigManager configManager;

    @Override
    public void enable() {
        CraftyService.setService(this);

        this.configManager = new ConfigManager(this.dataFolder);
        this.configManager.load();
    }

    @Override
    public void disable() {
        CraftyService.stopService();

        this.configManager.save();
    }

    @NotNull
    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}