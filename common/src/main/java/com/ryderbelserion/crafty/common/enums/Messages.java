package com.ryderbelserion.crafty.common.enums;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.properties.Property;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.common.config.ConfigKeys;
import com.ryderbelserion.crafty.common.config.MessageKeys;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;

public enum Messages {

    no_permission(MessageKeys.no_permission),
    config_reload(MessageKeys.config_reload),
    must_be_player(MessageKeys.must_be_player),
    must_be_console(MessageKeys.must_be_console),
    unknown_command(MessageKeys.unknown_command),
    invalid_arguments(MessageKeys.invalid_arguments),
    internal_error(MessageKeys.internal_error),
    cleared_ground_items(MessageKeys.cleared_ground_items),
    maintenance_mode(MessageKeys.maintenance_mode),
    maintenance_mode_enabled(MessageKeys.maintenance_mode_enabled),
    maintenance_mode_disabled(MessageKeys.maintenance_mode_disabled),
    no_ground_items(MessageKeys.no_ground_items);

    private final Property<String> property;

    private String message;

    Messages(Property<String> property) {
        this.property = property;
    }


    private final SettingsManager config = CraftyPlugin.getConfig();

    @NotNull
    private final SettingsManager messages = CraftyPlugin.getMessages();

    @NotNull
    private String getProperty(@NotNull Property<String> property) {
        return this.messages.getProperty(property);
    }

    @NotNull
    public Messages getMessage() {
        return getMessage(new HashMap<>());
    }

    @NotNull
    public Messages getMessage(@NotNull String placeholder, @NotNull String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);

        return getMessage(placeholders);
    }

    @NotNull
    public Messages getMessage(@NotNull HashMap<String, String> placeholder) {
        String message;

        message = getProperty(this.property);

        if (!placeholder.isEmpty()) {
            for (Map.Entry<String, String> value : placeholder.entrySet()) {
                message = message.replace(value.getKey(), value.getValue()).replace(value.getKey().toLowerCase(), value.getValue());
            }
        }

        this.message = message;

        return this;
    }

    @NotNull
    public String toMessage() {
        String prefix = this.config.getProperty(ConfigKeys.command_prefix);

        return this.message.replaceAll("\\{prefix}", prefix);
    }

    @NotNull
    public String toStringMessage() {
        return getMessage().message;
    }

    @NotNull
    public Component toSimpleComponent() {
        return AdvUtils.parse(getMessage().toMessage());
    }

    @NotNull
    public Component toAdvancedComponent() {
        return AdvUtils.parse(toMessage());
    }
}