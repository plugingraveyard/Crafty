package com.ryderbelserion.crafty.commands.subs;

import cloud.commandframework.context.CommandContext;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.crafty.commands.PaperCraftyCommand;
import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends PaperCraftyCommand {

    public TestCommand(CommandHandler handler) {
        super(handler);
    }

    @Override
    public void register() {
        getHandler().registerSubcommand(builder -> builder.literal("test")
                .permission("crafty.command.test")
                .handler(this::execute));
    }

    private void execute(CommandContext<@NotNull Sender> context) {
        context.getSender().sendMessage(AdvUtils.parse("Guten Nacht!"));
    }
}