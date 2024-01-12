package com.ryderbelserion.crafty.common.commands.subs;

import cloud.commandframework.context.CommandContext;
import cloud.commandframework.minecraft.extras.MinecraftExtrasMetaKeys;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import com.ryderbelserion.crafty.common.commands.CraftyCommand;
import com.ryderbelserion.crafty.common.enums.Messages;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand extends CraftyCommand {

    public ReloadCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void register() {
        getHandler().registerSubcommand(builder -> builder.literal("reload")
                .meta(MinecraftExtrasMetaKeys.DESCRIPTION, AdvUtils.parse("<red>This reloads the plugin.</red>"))
                .permission("crafty.command.reload")
                .handler(this::execute));
    }

    private void execute(CommandContext<@NotNull Sender> context) {
        CraftyPlugin.get().reload();

        context.getSender().sendMessage(AdvUtils.parse(Messages.config_reload.getMessage().build()));
    }
}