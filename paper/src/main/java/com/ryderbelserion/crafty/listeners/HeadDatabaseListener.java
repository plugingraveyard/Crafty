package com.ryderbelserion.crafty.listeners;

import com.ryderbelserion.cluster.ClusterFactory;
import com.ryderbelserion.crafty.Crafty;
import me.arcaniax.hdb.api.DatabaseLoadEvent;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class HeadDatabaseListener implements Listener {

    @NotNull
    private final Crafty plugin = Crafty.get();

    @NotNull
    private final ClusterFactory factory = this.plugin.getCluster();

    @EventHandler
    public void onDatabaseLoad(DatabaseLoadEvent event) {
        this.factory.setDatabaseAPI(new HeadDatabaseAPI());
    }
}