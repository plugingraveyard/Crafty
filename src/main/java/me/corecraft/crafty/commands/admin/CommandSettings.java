package me.corecraft.crafty.commands.admin;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotations.Command;
import me.corecraft.crafty.menus.SettingsMenu;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

@Command("crafty")
@Permission(value = "crafty.admin.settings", def = PermissionDefault.OP)
public class CommandSettings {

    @Command
    public void execute(Player player) {
        SettingsMenu.open(player);
    }
}