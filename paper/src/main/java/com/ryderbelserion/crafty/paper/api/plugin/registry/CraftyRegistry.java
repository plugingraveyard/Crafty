package com.ryderbelserion.crafty.paper.api.plugin.registry;

import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.plugin.CraftyPlugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;

import java.lang.reflect.Method;

public class CraftyRegistry {

    private static final Crafty plugin = JavaPlugin.getPlugin(Crafty.class);

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
            plugin.getLogger().severe("Failed to enable the crfty plugin.");
            plugin.getLogger().severe("Reason: " + exception.getMessage());
        }
    }

    @ApiStatus.Internal
    public static void stop() {
        try {
            stop.invoke(null);
        } catch (Exception exception) {
            plugin.getLogger().severe("Failed to disable crafty plugin.");
            plugin.getLogger().severe("Reason: " + exception.getMessage());
        }
    }
}