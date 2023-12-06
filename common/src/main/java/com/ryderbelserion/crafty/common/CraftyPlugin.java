package com.ryderbelserion.crafty.common;

import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.CraftyImpl;
import com.ryderbelserion.crafty.common.factory.ConfigFactory;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;

public abstract class CraftyPlugin implements CraftyImpl {

    private ConfigFactory configFactory;

    @Override
    public void enable(Path directory) {
        CraftyService.setService(this);

        this.configFactory = new ConfigFactory(directory);
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