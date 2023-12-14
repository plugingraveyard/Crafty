package com.ryderbelserion.crafty.common;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.CraftyImpl;
import com.ryderbelserion.crafty.common.config.ConfigKeys;
import com.ryderbelserion.crafty.common.config.MessageKeys;
import com.ryderbelserion.crafty.common.config.modules.HitDelayKeys;
import java.io.File;

public abstract class CraftyPlugin implements CraftyImpl {

    private static SettingsManager config;

    private static SettingsManager messages;

    @Override
    public void load(File dataFolder) {
        CraftyService.setService(this);

        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        config = SettingsManagerBuilder
                .withYamlFile(new File(dataFolder, "config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(ConfigKeys.class, HitDelayKeys.class)
                .create();

        messages = SettingsManagerBuilder
                .withYamlFile(new File(dataFolder, "messages.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(MessageKeys.class)
                .create();
    }

    @Override
    public void reload() {
        // Reload the config.yml
        config.reload();

        // Reload messages.yml
        messages.reload();
    }

    @Override
    public void disable() {
        CraftyService.stopService();

        // Reload the config.yml
        config.reload();

        // Reload messages.yml
        messages.reload();
    }

    public static SettingsManager getConfig() {
        return config;
    }

    public static SettingsManager getMessages() {
        return messages;
    }
}