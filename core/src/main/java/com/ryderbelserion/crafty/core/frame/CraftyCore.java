package com.ryderbelserion.crafty.core.frame;

import com.ryderbelserion.crafty.core.frame.storage.FileHandler;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.nio.file.Path;

public abstract class CraftyCore {

    public static @NotNull CraftyCore api() {
        return Provider.api();
    }

    public CraftyCore() {
        try {
            Field api = Provider.class.getDeclaredField("api");
            api.setAccessible(true);
            api.set(null, this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    protected static final class Provider {
        static CraftyCore api;

        static @NotNull CraftyCore api() {
            return Provider.api;
        }
    }

    public void enable() {}

    public void disable() {}

    public abstract Path getDirectory();

    public abstract String getPrefix();

    public abstract String getConsolePrefix();

    public abstract FileHandler getFileHandler();

    public abstract Audience adventure();
}