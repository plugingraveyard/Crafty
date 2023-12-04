package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.cluster.paper.ClusterFactory;
import com.ryderbelserion.cluster.paper.modules.ModuleLoader;
import com.ryderbelserion.cluster.paper.utils.AdvUtils;
import com.ryderbelserion.crafty.common.CraftyFactory;
import com.ryderbelserion.crafty.common.config.ConfigKeys;
import com.ryderbelserion.crafty.common.factory.ConfigFactory;
import com.ryderbelserion.crafty.paper.listeners.HeadDatabaseListener;
import com.ryderbelserion.crafty.paper.modules.HitDelayModule;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    public static Crafty get() {
        return JavaPlugin.getPlugin(Crafty.class);
    }

    private final CraftyFactory factory;

    private ModuleLoader moduleLoader;

    private ClusterFactory cluster;

    public Crafty(CraftyFactory factory) {
        this.factory = factory;
    }

    @Override
    public void onEnable() {
        // Enable cluster api
        this.cluster = new ClusterFactory(this, ConfigFactory.getConfig().getProperty(ConfigKeys.verbose_logging));
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
        if (this.factory != null) this.factory.disable();
    }

    public CraftyFactory getFactory() {
        return this.factory;
    }

    public ModuleLoader getModuleLoader() {
        return this.moduleLoader;
    }

    public ConfigFactory getConfigFactory() {
        return this.factory.getConfigFactory();
    }

    public void modules() {
        String prefix = ConfigFactory.getConfig().getProperty(ConfigKeys.console_prefix);

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
}