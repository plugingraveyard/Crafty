package me.corecraft.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import me.corecraft.crafty.api.PaperAbstractPlugin;
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