package com.ryderbelserion.crafty.paper.api;

import com.ryderbelserion.crafty.paper.Crafty;

public class CrazyManager {

    private final Crafty plugin;

    public CrazyManager(Crafty plugin) {
        this.plugin = plugin;
    }

    public void load(boolean serverStart) {
        if (serverStart) {

        }
    }

    public void reload(boolean serverStop) {
        //this.craftyPlugin.getConfigManager().reload();

        if (serverStop) {

        }
    }
}