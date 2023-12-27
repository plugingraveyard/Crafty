package com.ryderbelserion.crafty.api.database;

import com.ryderbelserion.crafty.api.database.impl.StorageImpl;

import java.sql.SQLException;

public class Storage {

    private final StorageImpl storage;

    public Storage(StorageImpl storage) {
        this.storage = storage;
    }

    public StorageImpl getStorage() {
        return this.storage;
    }

    public void init() {
        this.storage.init();
    }

    public void shutdown() {
        try {
            this.storage.shutdown();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}