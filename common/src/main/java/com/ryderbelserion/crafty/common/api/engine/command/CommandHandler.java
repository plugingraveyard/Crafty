package com.ryderbelserion.crafty.common.api.engine.command;

import cloud.commandframework.Command;
import cloud.commandframework.CommandManager;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.minecraft.extras.AudienceProvider;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import org.jetbrains.annotations.NotNull;

public abstract class CommandHandler {

    @NotNull
    public abstract CommandManager<@NotNull Sender> getManager();

    @NotNull
    public abstract Command.Builder<@NotNull Sender> getRoot();

    //TODO() Add exception handler.
    //TODO() Add register command method
    //TODO() Add a method to get the root command.
    //TODO() Add a way to expose registered commands, args etc for the help generator.

    protected Command.@NotNull Builder<@NotNull Sender> root() {
        return getManager().commandBuilder("crafty")
                .permission("crafty.access")
                .meta(CommandMeta.DESCRIPTION, "The base command for Crafty.")
                .handler(context -> {
                    MinecraftHelp<Sender> help = new MinecraftHelp<>(
                            "/crafty help",
                            AudienceProvider.nativeAudience(),
                            getManager()
                    );

                    help.setMessage("help", "Crafty Help");
                    help.queryCommands(context.getOrDefault("query", ""), context.getSender());

                   //TODO() Add some type of wrapper to open gui's
                });
    }

    protected void register() {

    }
}