package com.ryderbelserion.crafty.common.config.persist;

import com.ryderbelserion.cluster.api.config.StorageManager;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;
import java.util.List;

public non-sealed class SettingsHandler extends Settings {

    @NotNull
    private final StorageManager storageManager;

    private final Settings settings;

    public SettingsHandler(@NotNull StorageManager storageManager, @NotNull Path path) {
        super(path);

        this.settings = this;

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
        return worlds;
    }

    public void load() {
        this.storageManager.addFile(this.settings);
    }

    public void save() {
        this.storageManager.saveFile(this.settings);
    }
}