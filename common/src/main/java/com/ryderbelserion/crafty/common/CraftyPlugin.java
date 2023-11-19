package com.ryderbelserion.crafty.common;

import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.ICrafty;
import com.ryderbelserion.crafty.common.managers.ConfigFactory;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public abstract class CraftyPlugin implements ICrafty {

    private final File dataFolder;

    public CraftyPlugin(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    private ConfigFactory configFactory;

    @Override
    public void enable() {
        CraftyService.setService(this);

        this.configFactory = new ConfigFactory(this.dataFolder);
        this.configFactory.load();
    }

    @Override
    public void disable() {
        CraftyService.stopService();

        this.configFactory.save();
    }

    @NotNull
    public ConfigFactory getConfigFactory() {
        return this.configFactory;
    }
}