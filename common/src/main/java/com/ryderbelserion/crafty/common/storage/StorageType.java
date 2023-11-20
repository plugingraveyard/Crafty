package com.ryderbelserion.crafty.common.storage;

import java.util.List;

public enum StorageType {

    JSON("JSON", "json"),
    SQLITE("SQLITE", "sqlite");

    private final String name;
    private final List<String> identifiers;

    StorageType(String name, String... identifiers) {
        this.name = name;
        this.identifiers = List.of(identifiers);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getIdentifiers() {
        return this.identifiers;
    }
}