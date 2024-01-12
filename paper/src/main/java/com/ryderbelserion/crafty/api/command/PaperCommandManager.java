package com.ryderbelserion.crafty.api.command;

import cloud.commandframework.Command;
import cloud.commandframework.brigadier.CloudBrigadierManager;
import cloud.commandframework.bukkit.CloudBukkitCapabilities;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.command.types.BukkitSender;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import org.jetbrains.annotations.NotNull;

public class PaperCommandManager extends CommandHandler {

    private final cloud.commandframework.paper.PaperCommandManager<@NotNull Sender> manager;

    private final Command.Builder<@NotNull Sender> root;

    public PaperCommandManager(@NotNull Crafty plugin) throws Exception {
        this.manager = new cloud.commandframework.paper.PaperCommandManager<>(plugin, CommandExecutionCoordinator.simpleCoordinator(), BukkitSender::create, Sender::getSender);

        if (getManager().hasCapability(CloudBukkitCapabilities.NATIVE_BRIGADIER)) {
            getManager().registerBrigadier();

            CloudBrigadierManager<Sender, ?> brigadier = getManager().brigadierManager();

            if (brigadier != null) brigadier.setNativeNumberSuggestions(false);
        }

        if (getManager().hasCapability(CloudBukkitCapabilities.ASYNCHRONOUS_COMPLETION)) {
            getManager().registerAsynchronousCompletions();
        }

        exceptions();

        this.root = root();

        // Register root command.
        getManager().command(getRoot());

        // Register sub commands.
        register();
    }

    @Override
    public @NotNull cloud.commandframework.paper.PaperCommandManager<@NotNull Sender> getManager() {
        return this.manager;
    }

    @Override
    public @NotNull Command.Builder<Sender> getRoot() {
        return this.root;
    }
}