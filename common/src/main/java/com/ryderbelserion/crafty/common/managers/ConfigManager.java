package com.ryderbelserion.crafty.common.managers;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.cluster.api.config.StorageManager;
import com.ryderbelserion.crafty.common.config.Messages;
import com.ryderbelserion.crafty.common.config.PluginConfig;
import com.ryderbelserion.crafty.common.config.persist.SettingsHandler;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class ConfigManager {

    private final StorageManager storageManager;

    private final File dataFolder;

    public ConfigManager(StorageManager storageManager, File dataFolder) {
        this.dataFolder = dataFolder;

        this.storageManager = storageManager;
    }

    private SettingsHandler settingsHandler;

    private SettingsManager pluginConfig;

    private SettingsManager messages;

    public void load() {
        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        this.pluginConfig = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "plugin-config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(PluginConfig.class)
                .create();

        this.messages = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "messages.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(Messages.class)
                .create();

        this.settingsHandler = new SettingsHandler(this.storageManager, this.dataFolder.toPath());
    }

    public void reload() {
        this.pluginConfig.reload();

        this.messages.reload();

        this.settingsHandler.load();
        this.settingsHandler.save();
    }

    public void save() {
        this.pluginConfig.save();

        this.messages.save();

        this.settingsHandler.save();
    }

    @NotNull
    public SettingsHandler getSettingsHandler() {
        return this.settingsHandler;
    }

    @NotNull
    public SettingsManager getPluginConfig() {
        return this.pluginConfig;
    }

    @NotNull
    public SettingsManager getMessages() {
        return this.messages;
    }
}