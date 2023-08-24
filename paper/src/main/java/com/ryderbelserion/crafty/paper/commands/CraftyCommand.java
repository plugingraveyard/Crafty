package com.ryderbelserion.crafty.paper.commands;

import com.ryderbelserion.crafty.paper.commands.admin.ReloadCommand;
import com.ryderbelserion.crafty.paper.commands.player.HelpCommand;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandContext;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandEngine;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.Collections;
import java.util.List;

public class CraftyCommand extends PaperCommandEngine {

    private final com.ryderbelserion.crafty.paper.Crafty plugin = JavaPlugin.getPlugin(com.ryderbelserion.crafty.paper.Crafty.class);

    public CraftyCommand() {
        super("crafty", "The base command for crafty", "crafty", Collections.emptyList());

        addCommand(new ReloadCommand(), false);
        addCommand(new HelpCommand(), false);
    }

    @Override
    public void perform(PaperCommandContext context, String[] args) {
        this.plugin.getServer().dispatchCommand(context.getSender(), "crafty help 1");
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return handleTabComplete(sender, List.of(args));
    }
}