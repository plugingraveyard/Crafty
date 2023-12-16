package com.ryderbelserion.crafty.common.api;

import com.ryderbelserion.crafty.common.api.interfaces.AbstractPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class CraftyPlugin {

    private static AbstractPlugin plugin = null;

    @NotNull
    public static AbstractPlugin get() {
        AbstractPlugin instance = CraftyPlugin.plugin;

        if (instance == null) {
            throw new RuntimeException("Plugin variable not available");
        }

        return plugin;
    }

    @ApiStatus.Internal
    private CraftyPlugin() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    @ApiStatus.Internal
    public static void init(AbstractPlugin plugin) {
        if (CraftyPlugin.plugin != null) return;

        CraftyPlugin.plugin = plugin;
    }

    @ApiStatus.Internal
    public static void stop() {
        if (CraftyPlugin.plugin == null) return;

        CraftyPlugin.plugin = null;
    }
}