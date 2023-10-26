package com.ryderbelserion.crafty.common.config.persist.data;

import com.ryderbelserion.cluster.api.config.StorageManager;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public non-sealed class ServerHandler extends Server {

    @NotNull
    private final StorageManager storageManager;

    @NotNull
    private final Path path;

    public ServerHandler(@NotNull StorageManager storageManager, @NotNull Path path) {
        super(path);

        this.path = path;

        this.storageManager = storageManager;
    }

    public void load() {
        this.storageManager.addFile(new Server(this.path));
    }

    public void save() {
        this.storageManager.saveFile(new Server(this.path));
    }
}