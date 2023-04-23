package com.ryderbelserion.crafty.api.configs;

import ch.jalu.configme.configurationdata.ConfigurationData;
import ch.jalu.configme.configurationdata.ConfigurationDataBuilder;
import com.ryderbelserion.crafty.api.configs.types.ConfigSettings;

public class CraftyConfigBuilder {

    /**
     * Private constructor to prevent instantiation
     */
    private CraftyConfigBuilder() {}

    /**
     * Builds the core configuration data.
     *
     * @return configuration data object containing the main crate configurations.
     */
    public static ConfigurationData buildConfigurationData() {
        return ConfigurationDataBuilder.createConfiguration(
                ConfigSettings.class
        );
    }
}