package com.ryderbelserion.crafty.common.commands.subs;

import cloud.commandframework.context.CommandContext;
import cloud.commandframework.minecraft.extras.MinecraftExtrasMetaKeys;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import com.ryderbelserion.crafty.common.commands.CraftyCommand;
import org.jetbrains.annotations.NotNull;

public class HelpCommand extends CraftyCommand {

    public HelpCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void register() {
        getHandler().registerSubcommand(builder -> builder.literal("help")
                .meta(MinecraftExtrasMetaKeys.DESCRIPTION, AdvUtils.parse("<red>This is the help command.</red>"))
                .permission("crafty.command.help")
                .handler(this::execute));
    }

    private void execute(CommandContext<@NotNull Sender> context) {
        getHandler().generateHelp(context);
    }
}