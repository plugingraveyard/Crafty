package com.ryderbelserion.crafty.commands.admin.other;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.configs.types.LocaleSettings;
import com.ryderbelserion.crafty.api.configs.types.PluginSettings;
import com.ryderbelserion.crafty.api.utils.MessageSender;
import com.ryderbelserion.crafty.commands.CommandManager;
import org.bukkit.entity.Player;
import us.crazycrew.crazycore.utils.FileUtils;
import java.io.File;

public class CommandReload extends CommandManager {

    private final Crafty plugin = Crafty.getPlugin();

    //@Command("reload")
    //@Permission(value = "crafty.admin.reload", def = PermissionDefault.OP)
    public void execute(Player player) {
        plugin.getApiLoader().getPluginSettings().reload();

        FileUtils.extract("/locale/", plugin.getDataFolder().toPath(), false);

        File localeDirectory = new File(plugin.getDataFolder() + "/locale/");

        File localeFile = new File(localeDirectory, plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.LOCALE_FILE));

        SettingsManager localeSettings = SettingsManagerBuilder
                .withYamlFile(localeFile)
                .useDefaultMigrationService()
                .configurationData(LocaleSettings.class)
                .create();

        plugin.getApiLoader().setLocaleSettings(localeSettings);

        MessageSender.send(player, plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.COMMAND_RELOAD));
    }
}