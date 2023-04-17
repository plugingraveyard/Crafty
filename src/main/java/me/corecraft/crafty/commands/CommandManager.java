package me.corecraft.crafty.commands;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.annotations.Command;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.commands.admin.other.CommandReload;
import org.bukkit.command.CommandSender;

@Command("crafty")
public class CommandManager {

    private final Crafty plugin = Crafty.getPlugin();

    private final BukkitCommandManager<CommandSender> commandManager = BukkitCommandManager.create(plugin);

    @Command
    public void execute(CommandSender sender) {
        sender.sendMessage("This is a default command.");
    }

    public void setup() {
        commandManager.registerCommand(new CommandManager());

        commandManager.registerCommand(new CommandReload());
    }
}