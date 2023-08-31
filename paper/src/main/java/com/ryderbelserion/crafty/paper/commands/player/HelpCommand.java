package com.ryderbelserion.crafty.paper.commands.player;

import com.ryderbelserion.ruby.other.commands.args.Argument;
import com.ryderbelserion.ruby.other.commands.args.types.IntArgument;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandContext;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandEngine;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandHelpEntry;
import com.ryderbelserion.ruby.paper.plugin.commands.reqs.PaperRequirementsBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;
import java.util.Collections;
import java.util.List;

public class HelpCommand extends PaperCommandEngine {

    public HelpCommand() {
        super("help", "The help command for crafty", "crafty help", Collections.emptyList());

        addRequiredArgument(this, new Argument("page", 0, new IntArgument(3)));

        this.paperRequirements = new PaperRequirementsBuilder()
                .isPlayer(true)
                .withPermission(new Permission("crafty.help", PermissionDefault.TRUE)).build();
    }

    @Override
    public void perform(PaperCommandContext context, String[] args) {
        int argument = context.getArgAsInt(0, true, "not an integer.");

        PaperCommandHelpEntry helpEntry = new PaperCommandHelpEntry();

        helpEntry.setPage(argument);

        helpEntry.showHelp(context);
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return handleTabComplete(sender, List.of(args));
    }
}