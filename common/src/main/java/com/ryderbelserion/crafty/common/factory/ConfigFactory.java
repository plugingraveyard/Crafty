package com.ryderbelserion.crafty.common.factory;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.common.config.ConfigKeys;
import com.ryderbelserion.crafty.common.config.MessageKeys;
import com.ryderbelserion.crafty.common.config.modules.HitDelayKeys;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.nio.file.Path;

public class ConfigFactory {

    private final Path directory;

    public ConfigFactory(Path directory) {
        this.directory = directory;
    }

    private static SettingsManager config;

    private static SettingsManager messages;

    public void load() {
        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        config = SettingsManagerBuilder
                .withYamlFile(new File(this.directory.toFile(), "config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(ConfigKeys.class, HitDelayKeys.class)
                .create();

        messages = SettingsManagerBuilder
                .withYamlFile(new File(this.directory.toFile(), "messages.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(MessageKeys.class)
                .create();
    }

    public void reload() {
        config.reload();

        messages.reload();
    }

    public void save() {
        config.save();

        messages.save();
    }

    @NotNull
    public static SettingsManager getConfig() {
        return config;
    }

    @NotNull
    public static SettingsManager getMessages() {
        return messages;
    }
}