package com.ryderbelserion.crafty.paper.api;

import com.ryderbelserion.cluster.api.config.StorageManager;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.paper.api.managers.CommandManager;
import com.ryderbelserion.crafty.paper.modules.ModuleLoader;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class CrazyHandler extends CraftyPlugin {

    private CommandManager commandManager;
    private ModuleLoader moduleLoader;

    public CrazyHandler(StorageManager storageManager, File dataFolder) {
        super(storageManager, dataFolder);
    }

    public void enable() {
        super.enable();

        this.commandManager = new CommandManager();
        this.commandManager.load();

        this.moduleLoader = new ModuleLoader();
        this.moduleLoader.init();

        this.moduleLoader.toggle();
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