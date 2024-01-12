package com.ryderbelserion.crafty.common.commands;

import com.ryderbelserion.crafty.common.api.engine.command.CommandHandler;

public abstract class CraftyCommand {

    private final CommandHandler handler;

    public CraftyCommand(CommandHandler handler) {
        this.handler = handler;
    }

    public CommandHandler getHandler() {
        return this.handler;
    }

    public abstract void register();
}