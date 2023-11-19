package com.ryderbelserion.crafty.paper.api;

import com.ryderbelserion.cluster.paper.modules.ModuleLoader;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.commands.CommandManager;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class CrazyHandler extends CraftyPlugin {

    private CommandManager commandManager;
    private ModuleLoader moduleLoader;

    public CrazyHandler(Crafty plugin) {
        super(plugin.getDataFolder(), plugin.getLogger());
    }

    public void enable() {
        super.enable();

        this.commandManager = new CommandManager();
        this.commandManager.load();

        this.moduleLoader = new ModuleLoader();
        this.moduleLoader.load();
    }

    public void disable() {
        super.disable();
    }

    @NotNull
    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    @NotNull
    public ModuleLoader getModuleLoader() {
        return this.moduleLoader;
    }
}