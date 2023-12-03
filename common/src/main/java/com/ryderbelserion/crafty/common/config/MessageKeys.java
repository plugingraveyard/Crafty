package com.ryderbelserion.crafty.common.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import org.jetbrains.annotations.NotNull;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class MessageKeys implements SettingsHolder {

    private MessageKeys() {}

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
    public static final Property<String> no_permission = newProperty("misc.no-permission", "{prefix}<purple>Access denied! Lacking permission: <gold>{permission}");

    public static final Property<String> config_reload = newProperty("misc.config-reload", "{prefix}<white>Successfully <gold>reloaded <white>the <dark_aqua>plugin");

    public static final Property<String> must_be_player = newProperty("misc.must-be-player", "{prefix}<red>This command can only be used in-game");

    public static final Property<String> must_be_console = newProperty("misc.must-be-console", "{prefix}<red>This command can only be used in the console.");

    public static final Property<String> unknown_command = newProperty("misc.invalid-command", "{prefix}<red>The command <gold>{command} <red>is not a valid command.");

    public static final Property<String> invalid_arguments = newProperty("misc.invalid-args", "{prefix}<red>Invalid arguments! Correct Usage: <gold>{usage}");

    public static final Property<String> internal_error = newProperty("errors.internal-error", "{prefix}<red>An internal error has occurred. Please check the console for the full error.");

    public static final Property<String> cleared_ground_items = newProperty("clear.ground-items", "{prefix}<white>Successfully cleared <dark_aqua>{amount} <white>ground items in <dark_aqua>{world}.");

    public static final Property<String> no_ground_items = newProperty("clear.no-ground-items", "{prefix}<red>No ground items were found in <dark_aqua>{world}.");

    public static final Property<String> maintenance_mode = newProperty("maintenance.message", "{prefix}<white>Maintenance mode has been {toggle}.");

    public static final Property<String> maintenance_mode_enabled = newProperty("maintenance.enabled", "<green>enabled");

    public static final Property<String> maintenance_mode_disabled = newProperty("maintenance.disabled", "<red>disabled");

}