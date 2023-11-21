package com.ryderbelserion.crafty.api;

import java.nio.file.Path;

public interface CraftyImpl {

    void enable(Path directory);

    void disable();

}