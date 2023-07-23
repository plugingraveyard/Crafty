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

    public abstract String commandTooFewArgs();

    public abstract String commandTooManyArgs();

    public abstract String commandOptionalMsg();

    public abstract String commandRequiredMsg();

    public abstract String commandRequirementNotPlayer();

    public abstract String commandRequirementNoPermission();

    public abstract String commandHelpHeader();

    public abstract String commandHelpFooter();

    public abstract String commandInvalidPage();

    public abstract String commandPageFormat();

    public abstract String commandHoverFormat();

    public abstract String commandHoverAction();

    public abstract String commandNavigationText();

    public abstract String commandNavigationNextButton();

    public abstract String commandNavigationBackButton();
}