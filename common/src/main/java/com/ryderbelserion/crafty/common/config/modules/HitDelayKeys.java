package com.ryderbelserion.crafty.common.config.modules;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import java.util.List;
import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class HitDelayKeys implements SettingsHolder {

    private HitDelayKeys() {}

    @Comment("Defines how fast you want player's attack speed: The higher the number, the faster they attack.")
    public static final Property<Double> speed = newProperty("module.hit-delay.speed", 4.0);

    @Comment("The list of worlds where attack speed should be changed.")
    public static final Property<List<String>> worlds = newListProperty("module.hit-delay.worlds", List.of(
            "world"
    ));
}