package me.corecraft.crafty.commands;

import me.corecraft.crafty.Crafty;

//@Command("crafty")
//@Permission(value = "crafty.base", def = PermissionDefault.FALSE)
public class CommandManager {

    private final Crafty plugin = Crafty.getPlugin();

    //private final BukkitCommandManager<CommandSender> commandManager = BukkitCommandManager.create(plugin);

    //@Command
    //@Permission(value = "crafty.help", def = PermissionDefault.FALSE)
    //public void execute(CommandSender sender) {

    //}

    public void setup() {
        //commandManager.registerCommand(new CommandManager());
        //commandManager.registerCommand(new CommandReload());
    }
}