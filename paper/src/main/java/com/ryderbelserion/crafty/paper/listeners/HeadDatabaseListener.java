package com.ryderbelserion.crafty.paper.listeners;

import com.ryderbelserion.cluster.paper.ClusterFactory;
import com.ryderbelserion.crafty.paper.Crafty;
import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HeadDatabaseListener implements Listener {

    private final Crafty plugin = Crafty.get();

    private final ClusterFactory factory = this.plugin.getCluster();

    @EventHandler
    public void onDatabaseLoad(DatabaseLoadEvent event) {
        this.factory.setDatabaseAPI(new HeadDatabaseAPI());
    }
}