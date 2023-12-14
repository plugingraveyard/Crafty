package com.ryderbelserion.crafty.api;

import java.io.File;

public interface CraftyImpl {

    void load(File dataFolder);

    void reload();

    void disable();

}