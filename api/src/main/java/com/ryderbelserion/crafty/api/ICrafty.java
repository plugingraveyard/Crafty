package com.ryderbelserion.crafty.api;

import com.ryderbelserion.crafty.api.warps.SpawnManager;
import org.jetbrains.annotations.NotNull;
import com.ryderbelserion.crafty.api.platforms.Platform;
import java.io.File;

public interface ICrafty {

    @NotNull
    SpawnManager getSpawnManager();

    @NotNull
    Platform.type getPlatform();

    @NotNull
    File getDataFolder();

}