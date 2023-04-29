package com.ryderbelserion.crafty.commands.admin;

import co.aikar.commands.annotation.*;
import com.ryderbelserion.crafty.api.utils.Constants;
import com.ryderbelserion.crafty.commands.CraftyBaseCommand;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("gamemode|gm")
public class CommandGamemode extends CraftyBaseCommand {

    @Default
    public void execute(CommandSender sender, String[] args) {

        if (args.length == 0) return;


    }

    @Subcommand("creative")
    public void creative(CommandSender sender) {
        //execute(sender, GameMode.CREATIVE);
    }

    @Subcommand("survival")
    public void survival(CommandSender sender) {
        //execute(sender, GameMode.SURVIVAL);
    }

    @Subcommand("adventure")
    public void adventure(CommandSender sender) {
        //execute(sender, GameMode.ADVENTURE);
    }

    @Subcommand("spectator")
    public void spectator(CommandSender sender) {
        //execute(sender, GameMode.SPECTATOR);
    }
}