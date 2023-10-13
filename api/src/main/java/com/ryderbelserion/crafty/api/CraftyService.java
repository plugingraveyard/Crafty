package com.ryderbelserion.crafty.api;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public class CraftyService {

    private static ICrafty plugin = null;

    public static @NotNull ICrafty get() {
        ICrafty instance = CraftyService.plugin;

        if (instance == null) {
            throw new RuntimeException("Crafty service method not set. Please call the method setService before you try to use it!");
        }

        return plugin;
    }

    @ApiStatus.Internal
    private CraftyService() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    @ApiStatus.Internal
    public static void setService(ICrafty plugin) {
        if (CraftyService.plugin != null) return;

        CraftyService.plugin = plugin;
    }

    @ApiStatus.Internal
    public static void stopService() {
        if (CraftyService.plugin == null) return;

        CraftyService.plugin = null;
    }
}