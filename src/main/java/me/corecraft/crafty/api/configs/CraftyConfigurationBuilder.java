package me.corecraft.crafty.api.configs;

import ch.jalu.configme.configurationdata.ConfigurationData;
import ch.jalu.configme.configurationdata.ConfigurationDataBuilder;
import me.corecraft.crafty.api.configs.types.PluginSettings;

public class CraftyConfigurationBuilder {

    /**
     * Private constructor to prevent instantiation
     */
    private CraftyConfigurationBuilder() {}

    /**
     * Builds the core configuration data.
     *
     * @return configuration data object containing the main crate configurations.
     */
    public static ConfigurationData buildConfigurationData() {
        return ConfigurationDataBuilder.createConfiguration(
                PluginSettings.class
        );
    }
}