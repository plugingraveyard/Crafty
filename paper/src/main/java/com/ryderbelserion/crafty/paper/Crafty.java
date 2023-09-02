package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.paper.api.plugin.CraftyLoader;
import com.ryderbelserion.crafty.paper.commands.gamerule.GameRuleCommand;
import com.ryderbelserion.crafty.paper.commands.gamerule.gui.GameRuleListener;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private final BukkitCommandManager<CommandSender> commandManager = BukkitCommandManager.create(this);

    private CraftyLoader craftyLoader;

    @Override
    public void onEnable() {
        // This must go first!
        this.craftyLoader = new CraftyLoader();
        this.craftyLoader.enable();

        this.commandManager.registerCommand(new GameRuleCommand());

        getServer().getPluginManager().registerEvents(new GameRuleListener(), this);
    }

    @Override
    public void onDisable() {
        // This must go last!
        this.craftyLoader.disable();
    }
}