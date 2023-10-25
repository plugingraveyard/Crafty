package com.ryderbelserion.crafty.paper.commands.handlers;

import com.ryderbelserion.crafty.paper.api.enums.Translation;
import com.ryderbelserion.crafty.paper.commands.handlers.interfaces.MessageHandler;
import dev.triumphteam.cmd.bukkit.message.BukkitMessageKey;
import dev.triumphteam.cmd.core.message.MessageKey;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MiscRelations extends MessageHandler {

    @Override
    public void build() {
        getBukkitCommandManager().registerMessage(MessageKey.INVALID_ARGUMENT, (sender, context) -> send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", context.getTypedArgument()).toMessage())));

        getBukkitCommandManager().registerMessage(BukkitMessageKey.NO_PERMISSION, (sender, context) -> send(sender, parse(Translation.no_permission.getMessage("{permission}", context.getNodes().get(0)).toMessage())));

        getBukkitCommandManager().registerMessage(BukkitMessageKey.PLAYER_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_player.toMessage())));
        getBukkitCommandManager().registerMessage(BukkitMessageKey.CONSOLE_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_console.toMessage())));
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