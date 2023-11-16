package com.ryderbelserion.crafty.common.config.persist;

import com.ryderbelserion.cluster.api.config.StorageManager;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public non-sealed class SettingsHandler extends Settings {

    @NotNull
    private final StorageManager storageManager;

    @NotNull
    private final Path path;

    public SettingsHandler(@NotNull StorageManager storageManager, @NotNull Path path) {
        super(path);

        this.path = path;

        this.storageManager = storageManager;
    }

    public boolean isMaintenanceModeEnabled() {
        return maintenance_module;
    }

    public void setMaintenanceMode(boolean value) {
        maintenance_module = value;
    }

    public boolean isHitDelayEnabled() {
        return hit_delay_module;
    }

    public double getHitDelay() {
        return hit_delay;
    }

    public List<String> getWorldList() {
        return Collections.unmodifiableList(worlds);
    }

    public void load() {
        this.storageManager.addFile(new Settings(this.path));
    }

    public void save() {
        this.storageManager.saveFile(new Settings(this.path));
    }
}