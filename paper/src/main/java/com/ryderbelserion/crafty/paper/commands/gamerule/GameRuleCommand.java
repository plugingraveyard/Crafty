package com.ryderbelserion.crafty.paper.commands.gamerule;

import com.ryderbelserion.crafty.paper.commands.gamerule.gui.GameRuleInventory;
import dev.triumphteam.cmd.core.annotations.Command;
import org.bukkit.entity.Player;

@Command("gamerule")
public class GameRuleCommand {

    @Command
    public void gamerule(Player player) {
        player.openInventory(new GameRuleInventory().getInventory());
    }
}