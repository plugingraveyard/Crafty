package com.ryderbelserion.crafty.api.command;

import cloud.commandframework.Command;
import cloud.commandframework.brigadier.CloudBrigadierManager;
import cloud.commandframework.bukkit.CloudBukkitCapabilities;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.paper.PaperCommandManager;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.command.types.BukkitSender;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import org.jetbrains.annotations.NotNull;

public class BukkitCommandManager extends CommandHandler {

    private final PaperCommandManager<@NotNull Sender> manager;

    private final Command.Builder<@NotNull Sender> root;

    public BukkitCommandManager(@NotNull Crafty plugin) throws Exception {
        this.manager = new PaperCommandManager<>(plugin, CommandExecutionCoordinator.simpleCoordinator(), BukkitSender::create, Sender::getSender);

        if (getManager().hasCapability(CloudBukkitCapabilities.NATIVE_BRIGADIER)) {
            getManager().registerBrigadier();

            CloudBrigadierManager<Sender, ?> brigadier = getManager().brigadierManager();

            if (brigadier != null) brigadier.setNativeNumberSuggestions(false);
        }

        if (getManager().hasCapability(CloudBukkitCapabilities.ASYNCHRONOUS_COMPLETION)) {
            getManager().registerAsynchronousCompletions();
        }

        this.root = root();

        // Register root command.
        getManager().command(getRoot());

        // Register sub commands.
        register();
    }

    @Override
    public @NotNull PaperCommandManager<@NotNull Sender> getManager() {
        return this.manager;
    }

    @Override
    public @NotNull Command.Builder<Sender> getRoot() {
        return this.root;
    }
}