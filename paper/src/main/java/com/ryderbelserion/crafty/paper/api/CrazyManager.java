package com.ryderbelserion.crafty.paper.api;

import org.jetbrains.annotations.NotNull;

public class CrazyManager {

    //private final @NotNull CraftyPlugin craftyPlugin = CraftyProvider.get();

    public void load(boolean serverStart) {
        if (serverStart) {

        }
    }

    public void reload(boolean serverStop) {
        //this.craftyPlugin.getConfigManager().reload();

        if (serverStop) {

        }
    }
}