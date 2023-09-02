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
    private SettingsManager moduleConfig;

    public void load() {
        // Create the plugin-support.yml file object.
        File pluginConfig = new File(this.plugin.getDataFolder(), "plugin-config.yml");

        // Bind it to settings manager
        this.pluginConfig = SettingsManagerBuilder
                .withYamlFile(pluginConfig)
                .useDefaultMigrationService()
                .configurationData(createPluginConfig())
                .create();

        File moduleConfig = new File(this.plugin.getDataFolder(), "modules.yml");

        // Bind it to settings manager
        this.moduleConfig = SettingsManagerBuilder
                .withYamlFile(moduleConfig)
                .useDefaultMigrationService()
                .configurationData(createModuleConfig())
                .create();
    }

    public void reload() {
        // Reload modules.yml
        this.moduleConfig.reload();

        // Reload plugin-config.yml
        this.pluginConfig.reload();
    }

    public SettingsManager getPluginConfig() {
        return this.pluginConfig;
    }

    public SettingsManager getModuleConfig() {
        return this.moduleConfig;
    }

    private ConfigurationData createPluginConfig() {
        return ConfigurationDataBuilder.createConfiguration(PluginConfig.class);
    }

    private ConfigurationData createModuleConfig() {
        return ConfigurationDataBuilder.createConfiguration(ModuleConfig.class);
    }
}