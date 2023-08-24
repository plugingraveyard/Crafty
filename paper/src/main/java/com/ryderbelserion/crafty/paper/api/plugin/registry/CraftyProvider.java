package com.ryderbelserion.crafty.paper.api.plugin.registry;

import com.ryderbelserion.crafty.paper.api.plugin.CraftyPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class CraftyProvider {

    private static CraftyPlugin craftyPlugin = null;

    public static @NotNull CraftyPlugin get() {
        CraftyPlugin instance = CraftyProvider.craftyPlugin;

        if (instance == null) throw new RuntimeException("Failed to use the get() method. Contact the developer.");

        return craftyPlugin;
    }

    @ApiStatus.Internal
    public static void start(CraftyPlugin plugin) {
        CraftyProvider.craftyPlugin = plugin;
    }

    @ApiStatus.Internal
    public static void stop() {
        CraftyProvider.craftyPlugin = null;
    }
}