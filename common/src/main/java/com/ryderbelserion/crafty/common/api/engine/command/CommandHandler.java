package com.ryderbelserion.crafty.common.api.engine.command;

import cloud.commandframework.Command;
import cloud.commandframework.CommandManager;
import cloud.commandframework.meta.CommandMeta;
import com.ryderbelserion.cluster.utils.AdvUtils;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public abstract class CommandHandler {

    @NotNull
    public abstract CommandManager<Audience> getManager();

    @NotNull
    public abstract Command.Builder<Audience> getRoot();

    //TODO() Add exception handler.
    //TODO() Add register command method
    //TODO() Add a method to get the root command.
    //TODO() Add a way to expose registered commands, args etc for the help generator.

    protected Command.@NotNull Builder<@NotNull Audience> root() {
        return getManager().commandBuilder("crafty")
                .permission("crafty.access")
                .meta(CommandMeta.DESCRIPTION, "Crafty command. /crafty help")
                .handler(context -> {
                   context.getSender().sendMessage(AdvUtils.parse("<red>This is the base command."));

                   //TODO() Add some type of wrapper to open gui's
                });
    }

    protected void register() {

    }
}