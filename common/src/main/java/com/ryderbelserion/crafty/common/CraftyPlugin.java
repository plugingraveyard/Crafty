package com.ryderbelserion.crafty.common;

import com.ryderbelserion.cluster.api.config.StorageManager;
import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.ICrafty;
import com.ryderbelserion.crafty.common.managers.ConfigManager;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public abstract class CraftyPlugin implements ICrafty {

    private final StorageManager storageManager;
    private final File dataFolder;

    public CraftyPlugin(StorageManager storageManager, File dataFolder) {
        this.storageManager = storageManager;

        this.dataFolder = dataFolder;
    }

    private ConfigManager configManager;

    @Override
    public void enable() {
        CraftyService.setService(this);

        this.configManager = new ConfigManager(this.storageManager, this.dataFolder);
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
}