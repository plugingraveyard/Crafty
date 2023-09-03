package com.ryderbelserion.crafty.paper.commands.gamerule.gui;

import com.ryderbelserion.crafty.paper.Crafty;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class GameRuleListener implements Listener {

    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        /*Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory == null || !(clickedInventory.getHolder() instanceof GameRuleInventory inventory)) return;

        ItemStack itemStack = event.getCurrentItem();
        HumanEntity player = event.getWhoClicked();

        if (itemStack == null) return;

        event.setCancelled(true);

        String nbt = new NbtBuilder().getString(itemStack, "world-type");

        World world = this.plugin.getServer().getWorld(nbt);

        if (world != null) {
            Inventory newInventory = this.plugin.getServer().createInventory(event.getWhoClicked(), world.getGameRules().length, ColorUtils.parse("<red>" + nbt + "</red>"));

            // Close old inventory.
            inventory.getInventory().close();

            ItemBuilder disabled = ParentBuilder.of(Material.RED_WOOL);
            ItemBuilder enabled = ParentBuilder.of(Material.GREEN_WOOL);

            Arrays.stream(GameRule.values()).forEach(rule -> {
                GameRule<?> gameRule = GameRule.getByName(rule.getName());

                if (gameRule != null) {
                    Object value = world.getGameRuleValue(gameRule);

                    if (value != null) {
                        StringBuilder builder = new StringBuilder();

                        builder.append(gameRule.getName()).append(" : ").append(value);

                        if (gameRule.getType().equals(Boolean.class)) {
                            boolean isEnabled = Boolean.parseBoolean(value.toString());

                            if (isEnabled) {
                                newInventory.setItem(newInventory.firstEmpty(), enabled.setDisplayName(builder.toString()).build());
                            } else {
                                newInventory.setItem(newInventory.firstEmpty(), disabled.setDisplayName(builder.toString()).build());
                            }

                            return;
                        }

                        newInventory.setItem(newInventory.firstEmpty(), ParentBuilder.of(Material.EMERALD).setDisplayName(builder.toString()).build());
                    }
                }
            });

            // Open new one.
            player.openInventory(newInventory);
        }
         */
    }
}