package com.ryderbelserion.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.cluster.utils.modules.ModuleLoader;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import com.ryderbelserion.crafty.common.config.types.Config;
import com.ryderbelserion.crafty.modules.HitDelayModule;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private final PaperAbstractPlugin plugin;

    public Crafty(PaperAbstractPlugin plugin) {
        this.plugin = plugin;
    }

    private ClusterFactory cluster;

    private ModuleLoader moduleLoader;

    @Override
    public void onEnable() {
        // Enable cluster factory.
        this.cluster = new ClusterFactory(this, this.plugin.getConfig().getProperty(Config.verbose_logging));
        this.cluster.enable();

        // Load modules.
        this.moduleLoader = new ModuleLoader();
        this.moduleLoader.addModule(new HitDelayModule(this));

        this.moduleLoader.load();

        handleModules();
    }

    @Override
    public void onDisable() {
        // Shut down cluster factory.
        if (this.cluster != null) this.cluster.disable();
    }

    public void handleModules() {
        String prefix = this.plugin.getConfig().getProperty(Config.console_prefix);

        ConsoleCommandSender sender = getServer().getConsoleSender();

        this.moduleLoader.getModules().forEach(module -> {
            String misc = prefix + "<bold><gold>" + module.getModuleName() + "</gold>";

            if (module.isEnabled()) {
                sender.sendMessage(AdvUtils.parse(misc + " <green>ENABLED</green>."));
            } else {
                sender.sendMessage(AdvUtils.parse(misc + " <red>NOT ENABLED.</red>"));
            }
        });
    }

    public ClusterFactory getCluster() {
        return this.cluster;
    }

    public ModuleLoader getModuleLoader() {
        return this.moduleLoader;
    }
}