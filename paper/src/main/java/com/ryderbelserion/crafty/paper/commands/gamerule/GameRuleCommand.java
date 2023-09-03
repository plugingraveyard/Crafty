package com.ryderbelserion.crafty.paper.commands.gamerule;

import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.commands.gamerule.gui.GameRuleInventory;
import dev.triumphteam.cmd.core.annotations.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Command("gamerule")
public class GameRuleCommand {

    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    @Command
    public void gamerule(Player player) {
        GameRuleInventory gameRuleInventory = new GameRuleInventory(this.plugin);

        player.openInventory(gameRuleInventory.build().getInventory());
    }
}