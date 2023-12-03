package com.ryderbelserion.crafty.paper.commands.handlers;

import com.ryderbelserion.cluster.paper.utils.AdvUtils;
import com.ryderbelserion.crafty.paper.api.enums.Messages;
import com.ryderbelserion.crafty.paper.commands.handlers.interfaces.MessageHandler;
import dev.triumphteam.cmd.core.message.MessageKey;
import dev.triumphteam.cmd.core.message.context.DefaultMessageContext;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ArgumentRelations extends MessageHandler {

    private void getContext(@NotNull CommandSender sender, @NotNull DefaultMessageContext context) {
        String command = context.getCommand();

        String order = "/" + command + " " + context.getSubCommand() + " ";

        String correctUsage = null;

        if (command.equalsIgnoreCase("crafty")) {
            correctUsage = "/" + command;
        } else {
            switch (context.getSubCommand()) {
                case "clear" -> correctUsage = order + "<world>";
                case "maintenance" -> correctUsage = order + "<true/false>";
            }
        }

        if (correctUsage != null) {
            send(sender, parse(Messages.invalid_arguments.getMessage("{usage}", correctUsage).toMessage()));
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
                send(sender, parse(Messages.unknown_command.getMessage("{command}", command).toMessage()));
                return;
            }

            String commandOrder = "/" + command + " " + subCommand;

            send(sender, parse(Messages.unknown_command.getMessage("{command}", commandOrder).toMessage()));
        });
    }

    @Override
    public void send(@NotNull CommandSender sender, @NotNull Component component) {
        sender.sendMessage(component);
    }

    @Override
    public Component parse(@NotNull String message) {
        return AdvUtils.parse(message);
    }
}