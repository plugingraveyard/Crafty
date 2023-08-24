package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.crafty.paper.api.CrazyManager;
import com.ryderbelserion.crafty.paper.api.config.ConfigManager;
import com.ryderbelserion.crafty.paper.api.plugin.registry.CraftyRegistry;
import com.ryderbelserion.ruby.minecraft.plugin.FancyLogger;
import com.ryderbelserion.ruby.other.config.FileManager;
import com.ryderbelserion.ruby.paper.PaperPlugin;

public abstract class CraftyPlugin {

    public abstract FileManager getFileManager();

    public abstract FancyLogger getFancyLogger();

    public abstract PaperPlugin getPaperPlugin();

    public abstract ConfigManager getConfigManager();

    public abstract CrazyManager getCrazyManager();

    public void enable() {
        CraftyRegistry.start(this);
    }

    public void disable() {
        CraftyRegistry.stop();
    }
}