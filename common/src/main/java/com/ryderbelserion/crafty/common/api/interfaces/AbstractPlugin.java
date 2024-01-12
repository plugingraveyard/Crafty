package com.ryderbelserion.crafty.common.api.interfaces;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import net.kyori.adventure.platform.AudienceProvider;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public abstract class AbstractPlugin {

    public abstract File getDataFolder();

    public abstract void init();

    public abstract void stop();

    public abstract void reload();

    public abstract SettingsManager getConfig();

    public abstract SettingsManager getLocale();

    public abstract AudienceProvider adventure();

    public void enable() {
        CraftyPlugin.init(this);
    }

    public void disable() {
        CraftyPlugin.stop();
    }

    @NotNull
    public YamlFileResourceOptions indent() {
        return YamlFileResourceOptions.builder().indentationSize(2).build();
    }
}