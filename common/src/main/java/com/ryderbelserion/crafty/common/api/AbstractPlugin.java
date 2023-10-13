package com.ryderbelserion.crafty.common.api;

import com.ryderbelserion.crafty.api.ICrafty;
import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.platforms.Platform;
import com.ryderbelserion.crafty.common.config.ConfigManager;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public abstract class AbstractPlugin implements ICrafty {

    @NotNull
    public abstract ConfigManager getConfigManager();

    private final Platform.type platform;
    private final File dataFolder;

    public AbstractPlugin(File dataFolder, Platform.type platform) {
        this.dataFolder = dataFolder;
        this.platform = platform;
    }

    public void enablePlugin() {
        CraftyService.setService(this);
    }

    public void disablePlugin() {
        CraftyService.stopService();
    }

    @NotNull
    @Override
    public Platform.type getPlatform() {
        return this.platform;
    }

    @NotNull
    @Override
    public File getDataFolder() {
        return this.dataFolder;
    }
}