package me.corecraft.crafty.api.utils;

import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import net.kyori.adventure.audience.Audience;
import us.crazycrew.crazycore.CrazyLogger;
import us.crazycrew.crazycore.utils.AdventureUtils;

public class MessageSender {

    private static final Crafty plugin = Crafty.getPlugin();

    public static void send(Audience audience, String component) {
        String prefix = plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX);
        boolean isEnabled = plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX_TOGGLE);

        audience.sendMessage(isEnabled ? AdventureUtils.parse(prefix, false).append(AdventureUtils.parse(component, false)) : AdventureUtils.parse(component, false));
    }

    public static void send(String component) {
        if (plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.VERBOSE_LOGGING)) CrazyLogger.info(component);
    }
}