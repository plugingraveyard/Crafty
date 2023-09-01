package com.ryderbelserion.crafty.paper.api.plugin.registry;

import com.ryderbelserion.cluster.bukkit.api.adventure.FancyLogger;
import com.ryderbelserion.crafty.paper.api.plugin.CraftyPlugin;
import org.jetbrains.annotations.ApiStatus;
import java.lang.reflect.Method;

public class CraftyRegistry {

    private static final Method start;
    private static final Method stop;

    static {
        try {
            start = CraftyProvider.class.getDeclaredMethod("start", CraftyPlugin.class);
            start.setAccessible(true);

            stop = CraftyProvider.class.getDeclaredMethod("stop");
            stop.setAccessible(true);
        } catch (NoSuchMethodException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    @ApiStatus.Internal
    public static void start(CraftyPlugin craftyPlugin) {
        try {
            start.invoke(null, craftyPlugin);
        } catch (Exception exception) {
            FancyLogger.warn("Failed to enable the crafty plugin.");
            FancyLogger.debug("Reason: " + exception.getMessage());
        }
    }

    @ApiStatus.Internal
    public static void stop() {
        try {
            stop.invoke(null);
        } catch (Exception exception) {
            FancyLogger.warn("Failed to disable crafty plugin.");
            FancyLogger.debug("Reason: " + exception.getMessage());
        }
    }
}