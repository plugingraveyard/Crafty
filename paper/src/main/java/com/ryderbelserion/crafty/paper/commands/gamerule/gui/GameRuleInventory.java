package com.ryderbelserion.crafty.paper.commands.gamerule.gui;

import com.ryderbelserion.cluster.bukkit.api.utils.ColorUtils;
import com.ryderbelserion.cluster.bukkit.items.ItemBuilder;
import com.ryderbelserion.cluster.bukkit.items.NbtBuilder;
import com.ryderbelserion.cluster.bukkit.items.ParentBuilder;
import com.ryderbelserion.crafty.paper.Crafty;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class GameRuleInventory implements InventoryHolder {

    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    private final Inventory inventory;

    private int amount = 0;

    public GameRuleInventory() {
        this.inventory = this.plugin.getServer().createInventory(this, 27, ColorUtils.parse("<red>Change game rules</red>"));

        this.plugin.getServer().getWorlds().forEach(world -> {
            ItemStack nbt = new NbtBuilder().setString(new ItemStack(Material.GRASS_BLOCK), "world-type", world.getName());

            ItemBuilder item = ParentBuilder.of(nbt)
                    .setDisplayName("<green>" + world.getName() + "</green>")
                    .setDisplayLore(List.of(
                            "<red>Click me to change game rules</red>"
                    ));

            this.inventory.setItem(this.amount, item.build());
            this.amount++;
        });
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}