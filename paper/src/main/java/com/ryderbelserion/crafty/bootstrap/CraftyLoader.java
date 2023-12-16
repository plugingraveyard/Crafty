package com.ryderbelserion.crafty.bootstrap;

import com.ryderbelserion.crafty.Crafty;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CraftyLoader implements PluginBootstrap {

    private PaperAbstractPlugin plugin;

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        this.plugin = new PaperAbstractPlugin(context.getDataDirectory().toFile());
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        // Pass through the plugin constructor.
        return new Crafty(this.plugin);
    }
}