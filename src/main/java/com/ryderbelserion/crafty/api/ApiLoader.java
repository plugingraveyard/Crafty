package com.ryderbelserion.crafty.api;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import com.ryderbelserion.crafty.api.configs.types.ConfigSettings;
import com.ryderbelserion.crafty.api.configs.types.LocaleSettings;
import com.ryderbelserion.crafty.api.configs.types.PluginSettings;
import us.crazycrew.crazycore.paper.utils.FileUtils;
import java.io.File;
import java.nio.file.Path;

public class ApiLoader {

    private final Path path;

    public ApiLoader(Path path) {
        this.path = path;
    }

    private SettingsManager pluginSettings;
    private SettingsManager configSettings;
    private SettingsManager localeSettings;

    public void load() {
        File pluginSettings = new File(path.toFile(), "plugin-settings.yml");

        this.pluginSettings = SettingsManagerBuilder
                .withYamlFile(pluginSettings)
                .useDefaultMigrationService()
                .configurationData(PluginSettings.class)
                .create();

        File configSettings = new File(path.toFile(), "config.yml");

        this.configSettings = SettingsManagerBuilder
                .withYamlFile(configSettings)
                .useDefaultMigrationService()
                .configurationData(ConfigSettings.class)
                .create();

        FileUtils.extract("/locale/", path, false);

        File localeDirectory = new File(path + "/locale/");

        File localeFile = new File(localeDirectory, getPluginSettings().getProperty(PluginSettings.LOCALE_FILE));

        this.localeSettings = SettingsManagerBuilder
                .withYamlFile(localeFile)
                .useDefaultMigrationService()
                .configurationData(LocaleSettings.class)
                .create();
    }

    public SettingsManager getPluginSettings() {
        return this.pluginSettings;
    }

    public SettingsManager getConfigSettings() {
        return this.configSettings;
    }

    public SettingsManager getLocaleSettings() {
        return this.localeSettings;
    }

    public void setLocaleSettings(SettingsManager localeSettings) {
        this.localeSettings = localeSettings;
    }
}