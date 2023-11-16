package com.ryderbelserion.crafty.paper.commands;

import com.ryderbelserion.crafty.common.config.persist.Settings;
import com.ryderbelserion.crafty.common.config.persist.SettingsHandler;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.enums.Translation;
import com.ryderbelserion.crafty.paper.api.interfaces.ModuleHandler;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import dev.triumphteam.cmd.core.annotation.Suggestion;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

@Command("crafty")
public class CraftyCommand extends BaseCommand {

    @NotNull
    private final Crafty plugin = Crafty.get();

    @NotNull
    private final SettingsHandler settingsHandler = this.plugin.getConfigManager().getSettingsHandler();

    @Default
    @Permission(value = "crafty.help", def = PermissionDefault.TRUE)
    public void execute(Player player) {

    }

    @SubCommand("maintenance")
    @Permission(value = "crafty.maintenance", def = PermissionDefault.OP)
    public void maintenance(CommandSender sender) {
        this.settingsHandler.setMaintenanceMode(!this.settingsHandler.isMaintenanceModeEnabled());

        this.settingsHandler.save();
    }

    @SubCommand("clear")
    @Permission(value = "crafty.clear", def = PermissionDefault.OP)
    public void clear(CommandSender sender, @Suggestion("worlds") String world) {
        // Get world from args.
        World thyWorld = this.plugin.getServer().getWorld(world);

        // Check if world is null.
        if (thyWorld == null) return;

        // Remove all entities.
        List<Entity> items = thyWorld.getEntities().stream().filter(Item.class::isInstance).toList();

        if (items.isEmpty()) {
            sender.sendMessage(Translation.no_ground_items.getMessage("{world}", world).toAdvancedComponent());
            return;
        }

        int size = items.size();

        items.forEach(Entity::remove);

        HashMap<String, String> placeholders = new HashMap<>();

        placeholders.put("{world}", world);
        placeholders.put("{amount}", String.valueOf(size));

        sender.sendMessage(Translation.cleared_ground_items.getMessage(placeholders).toAdvancedComponent());
    }

    @SubCommand("reload")
    @Permission(value = "crafty.reload", def = PermissionDefault.OP)
    public void reload(CommandSender sender) {
        this.plugin.getConfigManager().reload();

        this.plugin.getModuleLoader().load();
        this.plugin.getModuleLoader().getModules().forEach(ModuleHandler::reload);

        // Send the sender that the reload is complete.
        sender.sendMessage(Translation.config_reload.toSimpleComponent());
    }
}