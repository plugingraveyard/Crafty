package me.corecraft.crafty.commands;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.commands.admin.CommandSettings;
import org.bukkit.command.CommandSender;

public class CommandManager {

    private final Crafty plugin = Crafty.getPlugin();

    private final BukkitCommandManager<CommandSender> commandManager = BukkitCommandManager.create(plugin);

    public void setup() {
        commandManager.registerCommand(new CommandSettings());
    }
}