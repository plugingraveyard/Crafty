package me.corecraft.crafty.commands.admin.other;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotations.Command;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

@Command("crafty")
@Permission(value = "crafty.admin.reload", def = PermissionDefault.OP)
public class CommandReload {

    private final Crafty plugin = Crafty.getPlugin();

    @Command("reload")
    public void execute(Player player) {
        plugin.getApiLoader().getPluginSettings().reload();

        String prefix = plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX_TOGGLE) ? plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX) : "";

        player.sendMessage(MiniMessage.miniMessage().deserialize(prefix + "You have reloaded the plugin."));
    }
}