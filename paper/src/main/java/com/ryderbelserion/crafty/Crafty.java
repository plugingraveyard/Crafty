package com.ryderbelserion.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.cluster.utils.modules.ModuleLoader;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import com.ryderbelserion.crafty.common.config.types.Config;
import com.ryderbelserion.crafty.listeners.HeadDatabaseListener;
import com.ryderbelserion.crafty.modules.HitDelayModule;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    public static Crafty get() {
        return JavaPlugin.getPlugin(Crafty.class);
    }

    private PaperAbstractPlugin plugin;

    private ModuleLoader moduleLoader;

    private ClusterFactory cluster;

    public Crafty(PaperAbstractPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEnable() {
        // Enable cluster api
        this.cluster = new ClusterFactory(this, this.plugin.getConfig().getProperty(Config.verbose_logging));
        this.cluster.enable();

        // Register headdatabase listener
        getServer().getPluginManager().registerEvents(new HeadDatabaseListener(), this);

        // Create object.
        this.moduleLoader = new ModuleLoader();

        // Add hit delay module.
        this.moduleLoader.addModule(new HitDelayModule());

        // Load modules.
        this.moduleLoader.load();

        // Check if modules are enabled.
        modules();
    }

    @Override
    public void onDisable() {
        // Disable cluster api
        if (this.cluster != null) this.cluster.disable();

        // Disable common factory
        //if (this.factory != null) this.factory.disable();
    }

    public CraftyPlugin getFactory() {
        return this.factory;
    }

    public ModuleLoader getModuleLoader() {
        return this.moduleLoader;
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