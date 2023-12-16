package com.ryderbelserion.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import com.ryderbelserion.crafty.common.config.types.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    public static Crafty get() {
        return JavaPlugin.getPlugin(Crafty.class);
    }

    private PaperAbstractPlugin plugin;

    private ClusterFactory cluster;

    public Crafty(PaperAbstractPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        // Enable cluster factory.
        this.cluster = new ClusterFactory(this, this.plugin.getConfig().getProperty(Config.verbose_logging));
        this.cluster.enable();
    }

    @Override
    public void onDisable() {
        // Shut down cluster factory.
        if (this.cluster != null) this.cluster.disable();
    }

    public void modules() {
        //String prefix = CraftyPlugin.getConfig().getProperty(Config.console_prefix);

        /*ConsoleCommandSender sender = getServer().getConsoleSender();

        this.moduleLoader.getModules().forEach(module -> {
            String misc = prefix + "<bold><gold>" + module.getModuleName() + "</gold>";

            if (module.isEnabled()) {
                sender.sendMessage(AdvUtils.parse(misc + " <green>ENABLED</green>."));
            } else {
                sender.sendMessage(AdvUtils.parse(misc + " <red>NOT ENABLED.</red>"));
            }
        });*/
    }

    public ClusterFactory getCluster() {
        return this.cluster;
    }
}