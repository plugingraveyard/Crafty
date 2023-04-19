package com.ryderbelserion.crafty.api.configs.types;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

/**
 * @author RyderBelserion
 *
 * Description: The plugin-settings.yml options.
 */
public class PluginSettings implements SettingsHolder {

    // Empty constructor required by SettingsHolder
    public PluginSettings() {}

    @Override
    public void registerComments(CommentsConfiguration conf) {
        String[] header = {
                "Github: https://github.com/corecraftmc",
                "",
                "Issues/Features: https://github.com/Crazy-Crew/Crafty/issues"
        };

        conf.setComment("settings", header);
    }

    @Comment("Whether the command prefix should be enabled.")
    public static final Property<Boolean> COMMAND_PREFIX_TOGGLE = newProperty("settings.prefix-toggle", true);

    @Comment("The command prefix that is shown at the beginning of every message.")
    public static final Property<String> COMMAND_PREFIX = newProperty("settings.command-prefix", "<red>[</red><green>Crafty</green><red>]</red> ");

    @Comment("The prefix that is shown for messages sent in console such as logging messages.")
    public static final Property<String> CONSOLE_PREFIX = newProperty("settings.console-prefix", "<gradient:#fe5f55:#6b55b5>[Crafty]</gradient> ");

    @Comment({
            "Choose the language you prefer to use on your server!",
            "",
            "Currently Available:",
            " > lang-en.yml ( English )",
            " > lang-de.yml ( German )",
            "",
            "If you do not see your language above, You can contribute by modifying the current lang-en.yml",
            "https://github.com/corecraftmc/Crafty/tree/main/src/main/resources/translations/locale-en.yml",
            ""
    })
    public static final Property<String> LOCALE_FILE = newProperty("settings.locale-file", "lang-en.yml");

    @Comment("Whether you want to have verbose logging enabled or not.")
    public static final Property<Boolean> VERBOSE_LOGGING = newProperty("settings.verbose-logging", true);
}