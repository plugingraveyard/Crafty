package com.ryderbelserion.crafty.paper.api.config;

import ch.jalu.configme.configurationdata.ConfigurationData;
import ch.jalu.configme.configurationdata.ConfigurationDataBuilder;
import com.ryderbelserion.crafty.paper.api.config.files.PluginSupport;

public class ConfigBuilder {

    private ConfigBuilder() {}

    public static ConfigurationData support() {
        return ConfigurationDataBuilder.createConfiguration(PluginSupport.class);
    }
}