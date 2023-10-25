package com.ryderbelserion.crafty.common.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import org.jetbrains.annotations.NotNull;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class Messages implements SettingsHolder {

    protected Messages() {}

    @Override
    public void registerComments(@NotNull CommentsConfiguration conf) {
        String[] header = {
                "Github: https://github.com/ryderbelserion/Crafty",
                "",
                "Issues: https://github.com/ryderbelserion/Crafty/issues",
                "Features: https://github.com/ryderbelserion/Crafty/issues",
                "",
                "Available Placeholders:",
                " - {prefix}",
                " - {usage} > Only used in invalid-args",
                " - {command} > Only used in invalid-command",
                " - {permission} > Only applicable for no-permission"
        };

        conf.setComment("misc", header);
    }

    @Comment({
            "The message sent when you are lacking required permissions.",
            "Available Placeholders:",
            " - {permission}",
            ""
    })
    public static final Property<String> no_permission = newProperty("misc.no-permission", "{prefix}<red>Access denied! Lacking permission: <gold>{permission}");

    public static final Property<String> config_reload = newProperty("misc.config-reload", "{prefix}<green>Successfully reloaded the config");

    public static final Property<String> must_be_player = newProperty("misc.must-be-player", "{prefix}<red>This command can only be used in-game");

    public static final Property<String> must_be_console = newProperty("misc.must-be-console", "{prefix}<red>This command can only be used in the console.");

    public static final Property<String> unknown_command = newProperty("misc.invalid-command", "{prefix}<red>The command <gold>{command} <red>is not a valid command.");

    public static final Property<String> invalid_arguments = newProperty("misc.invalid-args", "{prefix}<red>Invalid arguments! Correct Usage: <gold>{usage}");

    public static final Property<String> internal_error = newProperty("errors.internal-error", "{prefix}<red>An internal error has occurred. Please check the console for the full error.");

}