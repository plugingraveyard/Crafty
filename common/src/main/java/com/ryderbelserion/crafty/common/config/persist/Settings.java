package com.ryderbelserion.crafty.common.config.persist;

import com.google.gson.annotations.Expose;
import com.ryderbelserion.cluster.api.config.context.FileData;
import com.ryderbelserion.cluster.api.config.context.FileType;
import java.nio.file.Path;
import java.util.List;

public sealed class Settings extends FileData permits SettingsHandler {

    protected Settings(Path path) {
        super(FileType.json, "settings.json", path.toString(), false);
    }

    @Expose
    public static boolean maintenance_module = false;

    @Expose
    public static boolean hit_delay_module = false;

    @Expose
    public static double hit_delay = 40.0;

    @Expose
    public static List<String> worlds = List.of(
            "world",
            "world_nether"
    );
}