package com.ryderbelserion.crafty.common.storage.impl;

import com.ryderbelserion.crafty.common.CraftyPlugin;

public interface StorageImpl {

    CraftyPlugin getPlugin();

    String getImplName();

    void init();

    void stop();

}