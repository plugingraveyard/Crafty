package com.ryderbelserion.crafty.api.database;

import com.ryderbelserion.crafty.api.database.impl.StorageImpl;
import com.ryderbelserion.crafty.api.database.impl.sql.SqlStorage;
import com.ryderbelserion.crafty.api.database.impl.sql.file.types.SqliteConnection;
import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import com.ryderbelserion.crafty.common.config.types.Config;
import com.ryderbelserion.crafty.common.enums.storage.StorageType;
import java.io.File;

public class StorageFactory {

    public Storage getInstance() {
        Storage storage;

        storage = new Storage(create(CraftyPlugin.get().getConfig().getProperty(Config.storage_type)));

        storage.init();

        return storage;
    }

    private StorageImpl create(StorageType type) {
        switch (type) {
            case H2 -> {
                return new SqlStorage(new SqliteConnection(new File(CraftyPlugin.get().getDataFolder(), "users.db")));
            }

            case MARIADB -> {

            }

            default -> throw new RuntimeException("This method is not known: " + type);
        }

        return null;
    }
}