package me.corecraft.crafty.common.enums;

import ch.jalu.configme.properties.Property;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.cluster.utils.StringUtils;
import me.corecraft.crafty.common.api.CraftyImpl;
import com.ryderbelserion.crafty.common.api.interfaces.AbstractPlugin;
import me.corecraft.crafty.common.config.types.Config;
import me.corecraft.crafty.common.config.types.Locale;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Messages {

    no_permission(Locale.no_permission),
    config_reload(Locale.config_reload),
    must_be_player(Locale.must_be_player),
    must_be_console(Locale.must_be_console),
    unknown_command(Locale.unknown_command),
    invalid_arguments(Locale.invalid_arguments),
    internal_error(Locale.internal_error),
    cleared_ground_items(Locale.cleared_ground_items),
    maintenance_mode(Locale.maintenance_mode),
    maintenance_mode_enabled(Locale.maintenance_mode_enabled),
    maintenance_mode_disabled(Locale.maintenance_mode_disabled),
    no_ground_items(Locale.no_ground_items);

    private Property<String> property;

    private Property<List<String>> listProperty;

    private boolean isList = false;

    private String message;

    Messages(Property<String> property) {
        this.property = property;
    }

    /**
     * Used for string lists
     *
     * @param listProperty the list property
     * @param isList Defines if it's a list or not.
     */
    Messages(Property<List<String>> listProperty, boolean isList) {
        this.listProperty = listProperty;

        this.isList = isList;
    }

    @NotNull
    private final AbstractPlugin plugin = CraftyImpl.get();

    private boolean isList() {
        return this.isList;
    }

    @NotNull
    private List<String> getPropertyList(Property<List<String>> properties) {
        return this.plugin.getLocale().getProperty(properties);
    }

    @NotNull
    private String getProperty(Property<String> property) {
        return this.plugin.getLocale().getProperty(property);
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
    public Messages getMessage(Map<String, String> placeholders) {
        // Get the string first.
        String message;

        if (isList()) {
            message = StringUtils.convertList(getPropertyList(this.listProperty));
        } else {
            message = getProperty(this.property);
        }

        if (!placeholders.isEmpty()) {
            for (Map.Entry<String, String> placeholder : placeholders.entrySet()) {
                message = message.replace(placeholder.getKey(), placeholder.getValue()).replace(placeholder.getKey().toLowerCase(), placeholder.getValue());
            }
        }

        this.message = message;

        return this;
    }

    @NotNull
    public String build() {
        return this.message.replaceAll("\\{prefix}", this.plugin.getConfig().getProperty(Config.command_prefix));
    }

    public String raw() {
        return this.message;
    }

    public Component component() {
        return AdvUtils.parse(this.message.replaceAll("\\{prefix}", this.plugin.getConfig().getProperty(Config.command_prefix)));
    }

    public void sendMessage(Audience audience) {
        sendMessage(audience, new HashMap<>());
    }

    public void sendMessage(Audience audience, Map<String, String> placeholders) {
        audience.sendMessage(getMessage(placeholders).component());
    }
}