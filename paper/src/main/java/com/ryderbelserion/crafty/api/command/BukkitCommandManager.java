package com.ryderbelserion.crafty.api.command;

import cloud.commandframework.Command;
import cloud.commandframework.bukkit.CloudBukkitCapabilities;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.paper.PaperCommandManager;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class BukkitCommandManager extends CommandHandler {

    private final PaperCommandManager<@NotNull CommandSender> manager;

    private final Command.Builder<@NotNull Audience> root;

    public BukkitCommandManager(@NotNull Crafty plugin) throws Exception {
        this.manager = new PaperCommandManager<@NotNull CommandSender>(plugin, CommandExecutionCoordinator.simpleCoordinator(),  Function.identity(), Function.identity());

        if (getManager().hasCapability(CloudBukkitCapabilities.NATIVE_BRIGADIER)) {
            getManager().registerBrigadier();
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
    public @NotNull PaperCommandManager<Audience> getManager() {
        return null;
    }

    @Override
    public @NotNull Command.Builder<Audience> getRoot() {
        return null;
    }

    /*@NotNull
    @Override
    public @NotNull Command.Builder<Audience> getRoot() {
        return null;
    }*/
}