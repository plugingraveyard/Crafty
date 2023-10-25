package com.ryderbelserion.crafty.paper.api.managers;

import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.commands.handlers.ArgumentRelations;
import com.ryderbelserion.crafty.paper.commands.handlers.MiscRelations;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandManager {

    @NotNull
    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    @NotNull
    private final BukkitCommandManager<CommandSender> bukkitCommandManager = BukkitCommandManager.create(this.plugin);

    public void load() {
        //this.bukkitCommandManager.registerCommand(new StaffCommand());

        new MiscRelations().build();
        new ArgumentRelations().build();
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }
}