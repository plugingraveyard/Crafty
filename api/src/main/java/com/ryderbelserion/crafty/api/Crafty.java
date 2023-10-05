package com.ryderbelserion.crafty.api;

import org.jetbrains.annotations.NotNull;
import com.ryderbelserion.crafty.api.platforms.Platform;
import java.io.File;

public interface Crafty {

    @NotNull Platform.type getPlatform();

    @NotNull File getDataFolder();

}