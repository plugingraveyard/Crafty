package com.ryderbelserion.crafty.common.api.engine.command;

import ch.jalu.configme.SettingsManager;
import cloud.commandframework.Command;
import cloud.commandframework.CommandManager;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.minecraft.extras.AudienceProvider;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import com.ryderbelserion.crafty.common.api.interfaces.AbstractPlugin;
import com.ryderbelserion.crafty.common.config.types.Config;
import com.ryderbelserion.crafty.common.utils.ColorUtils;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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
                    AbstractPlugin plugin = CraftyPlugin.get();

                    SettingsManager config = plugin.getConfig();

                    MinecraftHelp<Sender> help = new MinecraftHelp<>(
                            "/crafty help",
                            AudienceProvider.nativeAudience(),
                            getManager()
                    );

                    help.setMessage("help", "Crafty Help");

                    help.setMaxResultsPerPage(config.getProperty(Config.help_max_results_per_page));

                    help.setHelpColors(MinecraftHelp.HelpColors.of(
                            ColorUtils.getColor(config.getProperty(Config.help_primary_color)),
                            ColorUtils.getColor(config.getProperty(Config.help_highlight_color)),
                            ColorUtils.getColor(config.getProperty(Config.help_alternate_highlight_color)),
                            ColorUtils.getColor(config.getProperty(Config.help_text_color)),
                            ColorUtils.getColor(config.getProperty(Config.help_accent_color))
                    ));

                    help.queryCommands(context.getOrDefault("query", ""), context.getSender());

                   //TODO() Add some type of wrapper to open gui's
                });
    }

    protected void register() {

    }
}