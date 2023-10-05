package com.ryderbelserion.crafty.common.api;

import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.crafty.api.Crafty;
import com.ryderbelserion.crafty.api.CraftyService;
import com.ryderbelserion.crafty.api.platforms.Platform;
import com.ryderbelserion.crafty.common.config.ConfigManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.File;
import java.util.List;

public abstract class AbstractPlugin implements Crafty {

    @Nullable
    public abstract String identifyClassLoader(ClassLoader classLoader) throws Exception;

    @NotNull
    public abstract ConfigManager getConfigManager();

    private final Platform.type platform;
    private final File dataFolder;

    public AbstractPlugin(File dataFolder, Platform.type platform) {
        this.dataFolder = dataFolder;
        this.platform = platform;
    }

    public void enablePlugin() {
        CraftyService.setService(this);
    }

    public void disablePlugin() {
        CraftyService.stopService();
    }

    @NotNull
    @Override
    public Platform.type getPlatform() {
        return this.platform;
    }

    @NotNull
    @Override
    public File getDataFolder() {
        return this.dataFolder;
    }

    /**
     * Made by lucko (luckperms)
     */
    public void apiWasLoadedByOurPlugin() {
        ClassLoader classLoader = this.platform.getClass().getClassLoader();

        for (Class<?> apiClass : new Class[]{Crafty.class, CraftyService.class}) {
            ClassLoader apiClassLoader = apiClass.getClassLoader();

            if (!apiClassLoader.equals(classLoader)) {
                String guilty = "unknown";

                try {
                    guilty = identifyClassLoader(apiClassLoader);
                } catch (Exception exception) {
                    // ignore
                }

                List.of(
                        "It seems that Crafty API has been class-loaded by a plugin other than Crafty!",
                        "The API seems to have been loaded by " + apiClassLoader + " (" + guilty + ") and the ",
                        "Crafty plugin was loaded by " + classLoader.toString() + ".",
                        "Another plugin must've incorrectly shaded Crafty API into the jar file which can cause runtime errors."
                ).forEach(FancyLogger::warn);

                return;
            }
        }
    }
}