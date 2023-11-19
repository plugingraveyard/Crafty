package com.ryderbelserion.crafty.common.storage.impl.file;

import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.common.storage.impl.StorageImpl;

public class ConfigurateFactory implements StorageImpl {

    private final CraftyPlugin plugin;

    private final String implName;

    public ConfigurateFactory(CraftyPlugin plugin, String implName) {
        this.plugin = plugin;

        this.implName = implName;
    }

    @Override
    public CraftyPlugin getPlugin() {
        return this.plugin;
    }

    @Override
    public String getImplName() {
        return this.implName;
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }
}