package com.ryderbelserion.crafty.paper.commands;

import com.ryderbelserion.cluster.paper.items.NbtBuilder;
import com.ryderbelserion.cluster.paper.items.ParentBuilder;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.enums.Translation;
import com.ryderbelserion.crafty.paper.api.interfaces.ModuleHandler;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

@Command("crafty")
public class CraftyCommand extends BaseCommand {

    @NotNull
    private final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

    @Default
    @Permission(value = "crafty.help", def = PermissionDefault.TRUE)
    public void execute(Player player) {

    }

    @SubCommand("reload")
    @Permission(value = "crafty.reload", def = PermissionDefault.FALSE)
    public void reload(CommandSender sender) {
        this.plugin.getConfigManager().reload();

        this.plugin.getModuleLoader().load();
        this.plugin.getModuleLoader().getModules().forEach(ModuleHandler::reload);

        // Send the sender that the reload is complete.
        sender.sendMessage(Translation.config_reload.toComponent());
    }

    @SubCommand("gate")
    public void gate(Player player) {
        ItemStack item = ParentBuilder.of(Material.STONE_AXE).build();

        NbtBuilder builder = new NbtBuilder(this.plugin, item);

        builder.setString("gate_creator", player.getUniqueId().toString());

        player.getInventory().addItem(builder.getItemStack());

        player.sendMessage(this.plugin.getPaperPlugin().parse("<red>You have been given a gate maker</red>"));
    }

    private final HashMap<Location, Location> locations = new HashMap<>();

    @SubCommand("gate save")
    public void gateSave(Player player) {

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

    }
}