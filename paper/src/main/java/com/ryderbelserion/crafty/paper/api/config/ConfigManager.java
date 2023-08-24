package com.ryderbelserion.crafty.paper.api.config;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class ConfigManager {

    private final com.ryderbelserion.crafty.paper.Crafty plugin = JavaPlugin.getPlugin(com.ryderbelserion.crafty.paper.Crafty.class);

    private static SettingsManager support;

    public void load() {
        // Create the plugin-support.yml file object.
        File pluginSupport = new File(this.plugin.getDataFolder(), "plugin-support.yml");

        // Bind it to settings manager
        support = SettingsManagerBuilder
                .withYamlFile(pluginSupport)
                .useDefaultMigrationService()
                .configurationData(ConfigBuilder.support())
                .create();
    }

    public void reload() {
        // Reload plugin-support.yml
        support.reload();
    }

    public static SettingsManager support() {
        return support;
    }
}