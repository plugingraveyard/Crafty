package com.ryderbelserion.crafty.common.storage;

import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.common.storage.impl.StorageImpl;
import com.ryderbelserion.crafty.common.storage.impl.file.ConfigurateFactory;

public class StorageFactory {

    private final CraftyPlugin plugin;

    public StorageFactory(CraftyPlugin plugin) {
        this.plugin = plugin;
    }

    private StorageImpl create(StorageType type) {
        switch (type) {
            case JSON -> {
                return new ConfigurateFactory(this.plugin, type.getName());
            }

            case SQLITE -> throw new RuntimeException("Cannot use SQLITE storage type yet.");

            default -> throw new RuntimeException("Unknown storage type: " + type.getName());
        }
    }
}