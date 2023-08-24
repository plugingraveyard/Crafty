package com.ryderbelserion.crafty.paper.api.plugin;

import com.ryderbelserion.crafty.paper.api.CrazyManager;
import com.ryderbelserion.crafty.paper.api.config.ConfigManager;
import com.ryderbelserion.ruby.minecraft.plugin.FancyLogger;
import com.ryderbelserion.ruby.other.config.FileManager;
import com.ryderbelserion.ruby.paper.PaperPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftyLoader extends CraftyPlugin {

    private final com.ryderbelserion.crafty.paper.Crafty plugin = JavaPlugin.getPlugin(com.ryderbelserion.crafty.paper.Crafty.class);

    private PaperPlugin paperPlugin;
    private ConfigManager configManager;
    private FileManager fileManager;
    private CrazyManager crazyManager;

    @Override
    public void enable() {
        super.enable();

        this.paperPlugin = new PaperPlugin(this.plugin);
        this.paperPlugin.enable(false);

        this.configManager = new ConfigManager();
        this.configManager.load();

        this.fileManager = new FileManager();

        this.crazyManager = new CrazyManager();
    }

    @Override
    public void disable() {
        super.disable();
    }

    @Override
    public FileManager getFileManager() {
        return this.fileManager;
    }

    @Override
    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    @Override
    public CrazyManager getCrazyManager() {
        return this.crazyManager;
    }

    @Override
    public FancyLogger getFancyLogger() {
        return this.paperPlugin.getFancyLogger();
    }

    @Override
    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }
}