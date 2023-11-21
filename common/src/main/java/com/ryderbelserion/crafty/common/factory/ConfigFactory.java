package com.ryderbelserion.crafty.common.factory;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.common.config.ConfigKeys;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.nio.file.Path;

public class ConfigFactory {

    private final Path directory;

    public ConfigFactory(Path directory) {
        this.directory = directory;
    }

    private SettingsManager config;

    public void load() {
        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        this.config = SettingsManagerBuilder
                .withYamlFile(new File(this.directory.toFile(), "config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(ConfigKeys.class)
                .create();
    }

    public void reload() {
        this.config.reload();
    }

    public void save() {
        this.config.save();
    }

    @NotNull
    public SettingsManager getConfig() {
        return this.config;
    }
}