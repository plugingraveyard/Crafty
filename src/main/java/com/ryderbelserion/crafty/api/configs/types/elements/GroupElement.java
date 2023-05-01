package com.ryderbelserion.crafty.api.configs.types.elements;

import java.util.Collections;
import java.util.HashMap;

public class GroupElement {

    private final HashMap<String, String> groups = new HashMap<>();

    public void addGroup(String group, String format) {
        groups.put(group, format);
    }

    public HashMap<String, String> getGroups() {
        return (HashMap<String, String>) Collections.unmodifiableMap(this.groups);
    }
}

/*
formats: -> Not Unique
 vip: -> Unique
  prefix: 'Hello' -> Not Unique
 default: -> Unique
  prefix: 'Hello x2' -> Not Unique
 */