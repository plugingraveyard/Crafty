package com.ryderbelserion.crafty.api.configs.types;

import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

/**
 * @author RyderBelserion
 *
 * Description: The lang-en.yml options.
 */
public class LocaleSettings implements SettingsHolder {

    // Empty constructor required by SettingsHolder
    public LocaleSettings() {}

    @Override
    public void registerComments(CommentsConfiguration conf) {
        String[] header = {
                "Github: https://github.com/corecraftmc",
                "",
                "Issues: https://github.com/corecraftmc/Crafty/issues",
                "Features: https://github.com/corecraftmc/Crafty/issues",
                "Translations: https://github.com/corecraftmc/Crafty/issues"
        };

        conf.setComment("misc", header);
    }

    public static final Property<String> ADMIN_HELP = newProperty("admin-help", """
            <red>/crafty reload</red> -> <yellow>This reloads the plugin.</red>
            """
    );

    public static final Property<String> UNKNOWN_COMMAND = newProperty("misc.unknown-command", "<red>This command is not known.</red>");

    public static final Property<String> FEATURE_DISABLED = newProperty("misc.feature-disabled", "<red>This feature is disabled. We have no ETA on when this will function.</red>");

    public static final Property<String> CORRECT_USAGE = newProperty("misc.correct-usage", "<red>The correct usage for this command is</red> <yellow>%usage%</yellow>");

    public static final Property<String> INTERNAL_ERROR = newProperty("errors.internal-error", "<red>An internal error has occurred. Please check the console for the full error.</red>");

    public static final Property<String> TOO_MANY_ARGS = newProperty("player.requirements.too-many-args", "<red>You put more arguments then I can handle.</red>");

    public static final Property<String> NOT_ENOUGH_ARGS = newProperty("player.requirements.not-enough-args", "<red>You did not supply enough arguments.</red>");

    public static final Property<String> MUST_BE_PLAYER = newProperty("player.requirements.must-be-player", "<red>You must be a player to use this command.</red>");

    public static final Property<String> MUST_BE_CONSOLE_SENDER = newProperty("player.requirements.must-be-console-sender", "<red>You must be using console to use this command.</red>");

    public static final Property<String> MUST_BE_LOOKING_AT_BLOCK = newProperty("player.requirements.must-be-looking-at-block", "<red>You must be looking at a block.</red>");

    public static final Property<String> COMMAND_CONFIRM_RELOAD = newProperty("command.reload.confirm-reload", "<yellow>Are you sure you want to reload the plugin?</yellow>");

    public static final Property<String> COMMAND_RELOAD = newProperty("command.reload.reload-completed", "<red>You have reloaded the plugin.</red>");
}