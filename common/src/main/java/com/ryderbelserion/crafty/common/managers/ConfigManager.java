package com.ryderbelserion.crafty.common.managers;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.common.config.Messages;
import com.ryderbelserion.crafty.common.config.PluginConfig;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class ConfigManager {

    private final File dataFolder;

    public ConfigManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

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
    }

    public void reload() {
        this.pluginConfig.reload();

        this.messages.reload();
    }

    public void save() {
        this.pluginConfig.save();

        this.messages.save();
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