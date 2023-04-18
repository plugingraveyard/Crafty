package me.corecraft.crafty.api;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import me.corecraft.crafty.api.configs.CraftyConfigurationBuilder;
import me.corecraft.crafty.api.configs.types.LocaleSettings;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import us.crazycrew.crazycore.utils.FileUtils;
import java.io.File;
import java.nio.file.Path;

public class ApiLoader {

    private final Path path;

    public ApiLoader(Path path) {
        this.path = path;
    }

    private SettingsManager pluginSettings;
    private SettingsManager localeSettings;

    public void load() {
        File pluginSettings = new File(path.toFile(), "plugin-settings.yml");

        this.pluginSettings = SettingsManagerBuilder
                .withYamlFile(pluginSettings)
                .useDefaultMigrationService()
                .configurationData(CraftyConfigurationBuilder.buildConfigurationData())
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

    public SettingsManager getLocaleSettings() {
        return this.localeSettings;
    }

    public void setLocaleSettings(SettingsManager localeSettings) {
        this.localeSettings = localeSettings;
    }
}