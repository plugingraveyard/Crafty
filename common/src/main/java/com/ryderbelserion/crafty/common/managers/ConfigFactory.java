package com.ryderbelserion.crafty.common.managers;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.common.config.Messages;
import com.ryderbelserion.crafty.common.config.Config;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class ConfigFactory {

    private final File dataFolder;

    public ConfigFactory(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    private SettingsManager config;

    private SettingsManager messages;

    public void load() {
        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        this.config = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(Config.class)
                .create();

        this.messages = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "messages.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(Messages.class)
                .create();
    }

    public void reload() {
        this.config.reload();

        this.messages.reload();
    }

    public void save() {
        this.config.save();

        this.messages.save();
    }

    @NotNull
    public SettingsManager getConfig() {
        return this.config;
    }

    @NotNull
    public SettingsManager getMessages() {
        return this.messages;
    }
}