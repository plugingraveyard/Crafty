package com.ryderbelserion.crafty.api.configs.types;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class AliasSettings implements SettingsHolder {

    // Empty constructor required by SettingsHolder
    public AliasSettings() {}

    @Override
    public void registerComments(CommentsConfiguration conf) {
        String[] header = {
                "Allows you to handle aliases for Crafty much like CMI does."
        };

        conf.setComment("short-hands", header);
    }

    @Comment("Whether you want the command to be /crafty feed or /feed")
    public static final Property<Boolean> FEED_COMMAND = newProperty("short-hands.feed.toggle", false);

    @Comment("Whether you want the command to be /crafty gamemode or /gamemode")
    public static final Property<Boolean> GAMEMODE_COMMAND = newProperty("short-hands.gamemode.toggle", false);

}