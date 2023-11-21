package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.common.CraftyFactory;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader extends CraftyFactory implements PluginBootstrap {

    private CraftyFactory factory;

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        super.enable(context.getDataDirectory());

        // Bind the factory variable.
        this.factory = this;
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        // Pass through the plugin constructor.
        return new Crafty(this.factory);
    }
}