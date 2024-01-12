package com.ryderbelserion.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import com.ryderbelserion.crafty.api.command.PaperCommandManager;
import com.ryderbelserion.crafty.common.config.types.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private PaperAbstractPlugin plugin;

    private ClusterFactory cluster;

    @Override
    public void onEnable() {
        this.plugin = new PaperAbstractPlugin(getDataFolder(), this);
        this.plugin.init();

        // Enable cluster factory.
        this.cluster = new ClusterFactory(this, this.plugin.getConfig().getProperty(Config.verbose_logging));
        this.cluster.enable();

        try {
            new PaperCommandManager(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Let's see if this works.
        // new ItemCommand(manager.getHandler()).register();
    }

    @Override
    public void onDisable() {
        if (this.plugin != null) this.plugin.stop();

        // Shut down cluster factory.
        if (this.cluster != null) this.cluster.disable();
    }

    public ClusterFactory getCluster() {
        return this.cluster;
    }
}