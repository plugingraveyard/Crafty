package com.ryderbelserion.crafty.paper.commands.gamerule.gui;

import com.ryderbelserion.cluster.bukkit.items.ItemBuilder;
import com.ryderbelserion.cluster.bukkit.items.NbtBuilder;
import com.ryderbelserion.cluster.bukkit.items.ParentBuilder;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.plugin.builder.gui.GuiBuilder;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import java.util.List;

public class GameRuleInventory extends GuiBuilder {

    private final Crafty plugin;

    private int amount;

    public GameRuleInventory(Crafty plugin) {
        super(plugin, 27, "<red>Change game rules</red>");

        this.plugin = plugin;
    }

    @Override
    public GuiBuilder build() {
        List<String> worlds = this.plugin.getServer().getWorlds().stream().map(World::getName).toList();

        worlds.forEach(world -> {
            ItemStack nbt = new NbtBuilder().setString(new ItemStack(Material.GRASS_BLOCK), "world-type", world);

            ItemBuilder item = ParentBuilder.of(nbt)
                    .setDisplayName("<green>" + world + "</green>")
                    .setDisplayLore(List.of(
                            "<red>Click me to change game rules </red>"
                    ));

            getInventory().setItem(this.amount, item.build());
            amount++;
        });

        return this;
    }
}