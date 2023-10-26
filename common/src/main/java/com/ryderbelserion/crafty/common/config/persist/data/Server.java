package com.ryderbelserion.crafty.common.config.persist.data;

import com.google.gson.annotations.Expose;
import com.ryderbelserion.cluster.api.config.context.FileData;
import com.ryderbelserion.cluster.api.config.context.FileType;
import com.ryderbelserion.crafty.common.data.Location;
import java.nio.file.Path;
import java.util.HashSet;

public sealed class Server extends FileData permits ServerHandler {

    public Server(Path path) {
        super(FileType.json, "server.json", path.toString(), true);
    }

    @Expose
    public static HashSet<Location> locations = new HashSet<>();

}