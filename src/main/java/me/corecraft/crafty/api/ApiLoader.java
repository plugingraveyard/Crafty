package me.corecraft.crafty.api;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import me.corecraft.crafty.api.configs.CraftyConfigurationBuilder;
import java.io.File;
import java.nio.file.Path;

public class ApiLoader {

    private final Path path;

    public ApiLoader(Path path) {
        this.path = path;
    }

    private SettingsManager pluginSettings;

    public void load() {
        File pluginSettings = new File(path.toFile(), "plugin-settings.yml");

        this.pluginSettings = SettingsManagerBuilder
                .withYamlFile(pluginSettings)
                .useDefaultMigrationService()
                .configurationData(CraftyConfigurationBuilder.buildConfigurationData())
                .create();
    }

    public SettingsManager getPluginSettings() {
        return pluginSettings;
    }
}