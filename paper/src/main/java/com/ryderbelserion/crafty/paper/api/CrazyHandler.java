package com.ryderbelserion.crafty.paper.api;

import com.ryderbelserion.cluster.api.config.StorageManager;
import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.paper.api.managers.CommandManager;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class CrazyHandler extends CraftyPlugin {

    private CommandManager commandManager;

    public CrazyHandler(StorageManager storageManager, File dataFolder) {
        super(storageManager, dataFolder);
    }

    public void enable() {
        super.enable();

        this.commandManager = new CommandManager();
        this.commandManager.load();
    }

    public void disable() {
        super.disable();
    }

    @NotNull
    public CommandManager getCommandManager() {
        return this.commandManager;
    }
}