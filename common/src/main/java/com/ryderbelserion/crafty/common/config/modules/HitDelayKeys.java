package com.ryderbelserion.crafty.common.config.modules;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class HitDelayKeys implements SettingsHolder {

    private HitDelayKeys() {}

    @Override
    public void registerComments(@NotNull CommentsConfiguration conf) {
        String[] modules = {
                "A section related to modules that can be disabled or enabled.",
                "",
                "Each module will be unregistered if the toggle is set to false",
                "You simply need to run /crafty reload"
        };

        conf.setComment("module", modules);
    }

    @Comment("Register or unregister the hit-delay module.")
    public static final Property<Boolean> toggle = newProperty("module.hit-delay.toggle", true);

    @Comment("Defines how fast you want player's attack speed: The higher the number, the faster they attack.")
    public static final Property<Double> speed = newProperty("module.hit-delay.speed", 4.0);

    @Comment("The list of worlds where attack speed should be changed.")
    public static final Property<List<String>> worlds = newListProperty("module.hit-delay.worlds", List.of(
            "world"
    ));
}