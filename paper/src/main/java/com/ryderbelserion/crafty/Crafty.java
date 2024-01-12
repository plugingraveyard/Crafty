package com.ryderbelserion.crafty;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.cluster.utils.AdvUtils;
import com.ryderbelserion.cluster.utils.modules.ModuleLoader;
import com.ryderbelserion.crafty.api.PaperAbstractPlugin;
import com.ryderbelserion.crafty.api.command.PaperCommandManager;
import com.ryderbelserion.crafty.commands.subs.TestCommand;
import com.ryderbelserion.crafty.common.config.types.Config;
import com.ryderbelserion.crafty.modules.HitDelayModule;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private PaperAbstractPlugin plugin;

    private ModuleLoader moduleLoader;

    private ClusterFactory cluster;

    @Override
    public void onEnable() {
        this.plugin = new PaperAbstractPlugin(getDataFolder(), this);
        this.plugin.init();

        // Enable cluster factory.
        this.cluster = new ClusterFactory(this, this.plugin.getConfig().getProperty(Config.verbose_logging));
        this.cluster.enable();

        // Load modules.
        this.moduleLoader = new ModuleLoader();
        this.moduleLoader.addModule(new HitDelayModule(this));

        this.moduleLoader.load();

        PaperCommandManager manager;

        try {
            manager = new PaperCommandManager(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Let's see if this works.
        new TestCommand(manager.getHandler()).register();

        printModules();
    }

    @Override
    public void onDisable() {
        this.plugin.disable();

        // Shut down cluster factory.
        if (this.cluster != null) this.cluster.disable();
    }

    public void printModules() {
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