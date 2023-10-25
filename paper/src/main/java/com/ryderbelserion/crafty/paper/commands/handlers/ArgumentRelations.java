package com.ryderbelserion.crafty.paper.commands.handlers;

import com.ryderbelserion.crafty.paper.api.enums.Translation;
import com.ryderbelserion.crafty.paper.commands.handlers.interfaces.MessageHandler;
import dev.triumphteam.cmd.core.message.MessageKey;
import dev.triumphteam.cmd.core.message.context.DefaultMessageContext;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ArgumentRelations extends MessageHandler {

    private void getContext(@NotNull CommandSender sender, @NotNull DefaultMessageContext context) {
        String command = context.getCommand();

        String correctUsage = null;

        if (command.equalsIgnoreCase("crafty")) correctUsage = "/" + command;

        if (correctUsage != null) {
            send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", correctUsage).toMessage()));
        }
    }

    @Override
    public void build() {
        getBukkitCommandManager().registerMessage(MessageKey.NOT_ENOUGH_ARGUMENTS, this::getContext);

        getBukkitCommandManager().registerMessage(MessageKey.TOO_MANY_ARGUMENTS, this::getContext);

        getBukkitCommandManager().registerMessage(MessageKey.UNKNOWN_COMMAND, (sender, context) -> {
            String command = context.getCommand();
            String subCommand = context.getSubCommand();

            if (subCommand.isBlank()) {
                send(sender, parse(Translation.unknown_command.getMessage("{command}", command).toMessage()));
                return;
            }

            String commandOrder = "/" + command + " " + subCommand;

            send(sender, parse(Translation.unknown_command.getMessage("{command}", commandOrder).toMessage()));
        });
    }

    @Override
    public void send(@NotNull CommandSender sender, @NotNull Component component) {
        sender.sendMessage(component);
    }

    @Override
    public Component parse(@NotNull String message) {
        return getPaperPlugin().parse(message);
    }
}