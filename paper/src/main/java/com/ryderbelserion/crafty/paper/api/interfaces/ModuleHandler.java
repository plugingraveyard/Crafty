package com.ryderbelserion.crafty.paper.api.interfaces;

import org.bukkit.event.Listener;

public abstract class ModuleHandler implements Listener {

    public ModuleHandler() {}

    public abstract boolean isEnabled();

    public abstract void reload();

}