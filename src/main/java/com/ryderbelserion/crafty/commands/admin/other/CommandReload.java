package com.ryderbelserion.crafty.commands.admin.other;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.configs.types.LocaleSettings;
import com.ryderbelserion.crafty.api.configs.types.PluginSettings;
import com.ryderbelserion.crafty.api.utils.Constants;
import com.ryderbelserion.crafty.api.utils.MessageUtils;
import com.ryderbelserion.crafty.commands.CraftyBaseCommand;
import org.bukkit.entity.Player;
import us.crazycrew.crazycore.paper.utils.FileUtils;
import java.io.File;

@CommandAlias("crazycrates")
public class CommandReload extends CraftyBaseCommand {

    private final Crafty plugin = Crafty.getPlugin();

    @Subcommand("reload")
    @Description("Reloads the configuration files for the plugin.")
    @CommandPermission(Constants.BASE_PERM + "reload")
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

        MessageUtils.send(player, plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.COMMAND_RELOAD));
    }
}