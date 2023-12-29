package com.ryderbelserion.crafty.common.config.types;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.properties.PropertyInitializer;
import com.ryderbelserion.crafty.common.enums.storage.StorageType;
import org.jetbrains.annotations.NotNull;

import static ch.jalu.configme.properties.PropertyInitializer.newBeanProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public final class Config implements SettingsHolder {

    private Config() {}

    @Override
    public void registerComments(@NotNull CommentsConfiguration conf) {
        String[] header = {
                "Support: https://discord.gg/w7yCw4M9za",
                "Github: https://github.com/ryderbelserion/Crafty",
                "",
                "Issues: https://github.com/ryderbelserion/Crafty/issues",
                "Features: https://github.com/ryderbelserion/Crafty/issues",
                ""
        };

        String[] deprecation = {
                "",
                "Warning: This section is subject to change so it is considered deprecated.",
                "This is your warning before the change happens.",
                ""
        };

        conf.setComment("verbose_logging", header);
    }

    @Comment({
            "Sends anonymous statistics about how the plugin is used to bstats.org.",
            "bstats is a service for plugin developers to find out how the plugin being used,",
            "This information helps us figure out how to better improve the plugin."
    })
    public static final Property<Boolean> toggle_metrics = newProperty("root.toggle_metrics", true);

    @Comment("Whether you want Crafty to shut up or not, This option is ignored by errors.")
    public static final Property<Boolean> verbose_logging = PropertyInitializer.newProperty("root.verbose_logging", true);

    @Comment("The command prefix you want shown in front of commands!")
    public static final Property<String> command_prefix = PropertyInitializer.newProperty("root.command_prefix", "<light_purple>Crafty | <reset>");

    @Comment("The command prefix you want shown in console!")
    public static final Property<String> console_prefix = PropertyInitializer.newProperty("root.console_prefix", "<light_purple>[Crafty] <reset>");

    @Comment("Pick which locale you want to use if your server is in another language. Changing this requires a server restart!")
    public static final Property<String> locale_file = newProperty("root.locale", "en-US");

    @Comment({
            "How the plugin should store data",
            "",
            "- Your Options",
            "| Remote Database Types - You need to supply connection information.",
            " |» MySQL *NOT IMPLEMENTED*",
            " |» MariaDB *NOT IMPLEMENTED*",
            "",
            "| Local Database Types",
            " |» H2 *NOT IMPLEMENTED*",
            " |» SQLITE *DEFAULT",
            "",
            "| Text File Based Storage",
            " |» JSON (.json files) *NOT IMPLEMENTED*"
    })
    public static final Property<StorageType> storage_type = newBeanProperty(StorageType.class, "root.database.storage-method", StorageType.H2);
}