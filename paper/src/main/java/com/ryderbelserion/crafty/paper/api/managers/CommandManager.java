package com.ryderbelserion.crafty.paper.api.managers;

import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.commands.CraftyCommand;
import com.ryderbelserion.crafty.paper.commands.handlers.ArgumentRelations;
import com.ryderbelserion.crafty.paper.commands.handlers.MiscRelations;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.suggestion.SuggestionKey;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandManager {

    @NotNull
    private final Crafty plugin = Crafty.get();

    @NotNull
    private final BukkitCommandManager<CommandSender> bukkitCommandManager = BukkitCommandManager.create(this.plugin);

    public void load() {
        new MiscRelations().build();
        new ArgumentRelations().build();

        this.bukkitCommandManager.registerCommand(new CraftyCommand());

        this.bukkitCommandManager.registerSuggestion(SuggestionKey.of("online-players"), (sender, context) -> this.plugin.getServer().getOnlinePlayers().stream().map(Player::getName).toList());

        this.bukkitCommandManager.registerSuggestion(SuggestionKey.of("worlds"), (sender, context) -> this.plugin.getServer().getWorlds().stream().map(World::getName).toList());

        this.bukkitCommandManager.registerSuggestion(SuggestionKey.of("numbers"), (sender, context) -> {
            List<String> numbers = new ArrayList<>();

            for (int i = 1; i <= 100; i++) numbers.add(String.valueOf(i));

            return numbers;
        });
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }
}