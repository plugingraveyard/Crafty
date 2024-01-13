package me.corecraft.crafty.common.api;

import ch.jalu.configme.resource.YamlFileResourceOptions;

public interface CraftyAPI {

    double version();

    void init();

    void stop();

    void reload();

    default YamlFileResourceOptions indent() {
        return YamlFileResourceOptions.builder().indentationSize(2).build();
    }
}