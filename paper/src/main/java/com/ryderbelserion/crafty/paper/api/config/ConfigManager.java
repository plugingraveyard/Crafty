package com.ryderbelserion.crafty.paper.api.config;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.configurationdata.ConfigurationData;
import ch.jalu.configme.configurationdata.ConfigurationDataBuilder;
import com.ryderbelserion.crafty.paper.Crafty;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class ConfigManager {

    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    private SettingsManager pluginConfig;

    public void load() {
        // Create the plugin-support.yml file object.
        File pluginSupport = new File(this.plugin.getDataFolder(), "plugin-support.yml");

        // Bind it to settings manager
        this.pluginConfig = SettingsManagerBuilder
                .withYamlFile(pluginSupport)
                .useDefaultMigrationService()
                .configurationData(createPluginConfig())
                .create();
    }

    public void reload() {
        // Reload plugin-support.yml
        this.pluginConfig.reload();
    }

    public SettingsManager getPluginConfig() {
        return this.pluginConfig;
    }

    private ConfigurationData createPluginConfig() {
        return ConfigurationDataBuilder.createConfiguration(PluginConfig.class);
    }
}