package com.ryderbelserion.crafty.paper.commands.handlers.interfaces;

import com.ryderbelserion.cluster.paper.ClusterFactory;
import com.ryderbelserion.crafty.paper.Crafty;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public abstract class MessageHandler {

    @NotNull
    private final Crafty plugin = Crafty.get();

    @NotNull
    private final BukkitCommandManager<CommandSender> bukkitCommandManager = this.plugin.getCommandManager();

    @NotNull
    private final ClusterFactory factory = this.plugin.getFactory();

    @NotNull
    public ClusterFactory getFactory() {
        return this.factory;
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }

    public abstract void build();

    public abstract void send(@NotNull CommandSender sender, @NotNull Component component);

    public abstract Component parse(@NotNull String message);

}