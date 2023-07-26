package com.ryderbelserion.crafty.fabric.server.api.frame;

import com.ryderbelserion.crafty.core.frame.CraftyCore;
import com.ryderbelserion.crafty.core.frame.storage.FileHandler;
import net.kyori.adventure.audience.Audience;
import java.nio.file.Path;

public class FabricCore extends CraftyCore {


    @Override
    public Path getDirectory() {
        return null;
    }

    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public String getConsolePrefix() {
        return null;
    }

    @Override
    public FileHandler getFileHandler() {
        return null;
    }

    @Override
    public Audience adventure() {
        return null;
    }
}