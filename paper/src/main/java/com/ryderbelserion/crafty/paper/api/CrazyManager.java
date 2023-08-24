package com.ryderbelserion.crafty.paper.api;

import com.ryderbelserion.crafty.paper.api.plugin.CraftyPlugin;
import com.ryderbelserion.crafty.paper.api.plugin.registry.CraftyProvider;
import org.jetbrains.annotations.NotNull;

public class CrazyManager {

    private final @NotNull CraftyPlugin craftyPlugin = CraftyProvider.get();

    public void load(boolean serverStart) {
        if (serverStart) {

        }
    }

    public void reload(boolean serverStop) {
        this.craftyPlugin.getConfigManager().reload();

        if (serverStop) {

        }
    }
}