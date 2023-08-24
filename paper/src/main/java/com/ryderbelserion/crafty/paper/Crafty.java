package com.ryderbelserion.crafty.paper;

import com.ryderbelserion.crafty.paper.api.plugin.CraftyLoader;
import com.ryderbelserion.crafty.paper.commands.CraftyCommand;
import com.ryderbelserion.crafty.paper.commands.CraftyHelpData;
import com.ryderbelserion.ruby.paper.plugin.commands.PaperCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafty extends JavaPlugin {

    private CraftyLoader craftyLoader;

    @Override
    public void onEnable() {
        // This must go first!
        this.craftyLoader = new CraftyLoader();
        this.craftyLoader.enable();

        this.craftyLoader.getPaperPlugin().setHelpProvider(new CraftyHelpData());

        PaperCommandManager manager = this.craftyLoader.getPaperPlugin().getManager();

        manager.setNamespace("crafty");

        manager.addCommand(new CraftyCommand(), true);

        this.craftyLoader.getFancyLogger().debug("Guten Tag!");
    }

    @Override
    public void onDisable() {
        this.craftyLoader.getFancyLogger().debug("Gute Nacht!");

        // This must go last!
        this.craftyLoader.disable();
    }
}