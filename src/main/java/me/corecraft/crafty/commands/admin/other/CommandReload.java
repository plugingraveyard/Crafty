package me.corecraft.crafty.commands.admin.other;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.api.configs.types.LocaleSettings;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import me.corecraft.crafty.api.utils.MessageSender;
import me.corecraft.crafty.commands.CommandManager;
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