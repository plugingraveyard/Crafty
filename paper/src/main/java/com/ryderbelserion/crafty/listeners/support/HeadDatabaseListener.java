package com.ryderbelserion.crafty.listeners.support;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.crafty.Crafty;
import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HeadDatabaseListener implements Listener {

    private final ClusterFactory factory;

    public HeadDatabaseListener(Crafty plugin) {
        this.factory = plugin.getCluster();
    }

    @EventHandler
    public void onDatabaseLoad(DatabaseLoadEvent event) {
        this.factory.setDatabaseAPI(new HeadDatabaseAPI());
    }
}