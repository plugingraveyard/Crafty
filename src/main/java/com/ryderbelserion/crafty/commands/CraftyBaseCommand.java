package com.ryderbelserion.crafty.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.HelpEntry;
import co.aikar.commands.PaperCommandManager;
import co.aikar.commands.annotation.*;
import com.google.common.collect.ImmutableList;
import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.configs.types.LocaleSettings;
import com.ryderbelserion.crafty.api.configs.types.PluginSettings;
import com.ryderbelserion.crafty.api.utils.Constants;
import com.ryderbelserion.crafty.api.utils.MessageUtils;
import com.ryderbelserion.crafty.commands.admin.CommandGamemode;
import com.ryderbelserion.crafty.commands.admin.other.CommandReload;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.List;

@CommandAlias("crafty")
@Description("Manage or use the Crafty plugin.")
@CommandPermission(Constants.BASE_PERM + "base")
public class CraftyBaseCommand extends BaseCommand {

    private final Crafty plugin = Crafty.getPlugin();

    @Subcommand("help")
    @Description("The base help command for the plugin.")
    @CommandPermission(Constants.BASE_PERM + "help")
    public void help(CommandSender sender, @Syntax("[page]") CommandHelp help) {
        help.setPerPage(plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.MAX_HELP_PAGE_ENTRIES));

        generateHelp(help.getPerPage(), help.getPage(), help.getHelpEntries(), sender);
    }

    public static void setup(PaperCommandManager manager) {
        manager.enableUnstableAPI("help");

        registerCompletions(manager);

        manager.registerCommand(new CraftyBaseCommand());

        manager.registerCommand(new CommandReload());

        manager.registerCommand(new CommandGamemode());
    }

    private static void registerCompletions(PaperCommandManager manager) {
        manager.getCommandCompletions().registerCompletion("gm-options", options -> ImmutableList.of("creative", "survival", "adventure", "spectator"));
    }

    private void generateHelp(int maxPage, int page, List<HelpEntry> entries, CommandSender sender) {
        int pageStartEntry = maxPage * (page - 1);

        String invalidPage = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.INVALID_PAGE).replaceAll("%page%", String.valueOf(page));

        if (page <= 0 || pageStartEntry >= entries.size()) {
            MessageUtils.send(sender, invalidPage);
            return;
        }

        String hoverFormat = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.HOVER_FORMAT);
        String hoverAction = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.HOVER_ACTION);

        String header = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.HELP_HEADER).replaceAll("%page%", String.valueOf(page));

        MessageUtils.send(sender, header, false);

        for (int i = pageStartEntry; i < (pageStartEntry + maxPage); i++) {
            if (entries.size()-1 < i) continue;

            HelpEntry command = entries.get(i);

            if (!command.shouldShow()) continue;

            String name = command.getCommandPrefix() + command.getCommand();
            String desc = command.getDescription();

            String format = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.PAGE_FORMAT)
                    .replaceAll("%command%", name)
                    .replaceAll("%description%", desc);

            String builtCommand = command.getParameters().length > 0 ? format.replaceAll("%args%", command.getParameterSyntax()) : format;

            if (sender instanceof Player player) {
                MessageUtils.hover(
                        player,
                        builtCommand,
                        hoverFormat.replaceAll("%command%", name).replaceAll("%args%", command.getParameterSyntax()),
                        name,
                        ClickEvent.Action.valueOf(hoverAction.toUpperCase()));
            } else {
                MessageUtils.send(sender, format, false);
            }
        }

        String pageTag = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.GO_TO_PAGE);

        String footer = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.HELP_FOOTER);

        String back = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.PAGE_BACK);

        String next = plugin.getApiLoader().getLocaleSettings().getProperty(LocaleSettings.PAGE_NEXT);

        if (sender instanceof Player player) {
            if (page > 1) {
                int number = page-1;

                MessageUtils.hover(player, footer.replaceAll("%page%", String.valueOf(page)),  pageTag.replaceAll("%page%", String.valueOf(number)), back,"/crazycrates help " + number, ClickEvent.Action.RUN_COMMAND);
            } else if (page < entries.size()) {
                int number = page+1;

                MessageUtils.hover(player, footer.replaceAll("%page%", String.valueOf(page)),  pageTag.replaceAll("%page%", String.valueOf(number)), next,"/crazycrates help " + number, ClickEvent.Action.RUN_COMMAND);
            }
        } else {
            MessageUtils.send(sender, footer.replaceAll("%page%", String.valueOf(page)), false);
        }
    }
}