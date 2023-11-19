package com.ryderbelserion.crafty.common.storage.impl.file.types;

import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.loader.ConfigurationLoader;
import java.nio.file.Path;

public interface IConfigurateLoader {

    ConfigurationLoader<? extends ConfigurationNode> loader(Path path);

}