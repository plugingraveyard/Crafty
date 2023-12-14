package com.ryderbelserion.crafty.bootstrap;

import com.ryderbelserion.crafty.common.CraftyPlugin;
import com.ryderbelserion.crafty.Crafty;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader extends CraftyPlugin implements PluginBootstrap {

    private CraftyPlugin factory;

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        super.load(context.getDataDirectory().toFile());

        // Bind the factory variable.
        this.factory = this;
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        // Pass through the plugin constructor.
        return new Crafty(this.factory);
    }
}