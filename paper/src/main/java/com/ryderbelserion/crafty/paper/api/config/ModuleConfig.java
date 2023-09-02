package com.ryderbelserion.crafty.paper.api.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.properties.PropertyInitializer;

public class ModuleConfig implements SettingsHolder {

    protected ModuleConfig() {}

    @Comment("Do you want to be able to use /crafty gamerules?")
    public static final Property<Boolean> GAMERULE_MODULE = PropertyInitializer.newProperty("modules.gamerule_module", false);

}