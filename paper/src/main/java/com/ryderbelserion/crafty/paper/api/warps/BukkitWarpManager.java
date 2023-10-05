package com.ryderbelserion.crafty.paper.api.warps;

import com.ryderbelserion.crafty.api.warps.WarpManager;
import com.ryderbelserion.crafty.api.warps.records.Location;
import java.util.List;
import java.util.UUID;

public class BukkitWarpManager extends WarpManager {

    private Location location;

    @Override
    public int x() {
        return this.location.x();
    }

    @Override
    public int y() {
        return this.location.y();
    }

    @Override
    public int z() {
        return this.location.z();
    }

    @Override
    public float pitch() {
        return this.location.pitch();
    }

    @Override
    public float yaw() {
        return this.location.yaw();
    }

    @Override
    public String world() {
        return this.location.world();
    }

    @Override
    public UUID setCreator(UUID uuid) {
        return null;
    }

    @Override
    public UUID getCreator() {
        return null;
    }

    @Override
    public UUID setEditor(UUID uuid) {
        return null;
    }

    @Override
    public List<UUID> getEditors() {
        return null;
    }

    @Override
    public void addWarp(String warp, Location location) {
        this.location = location;
    }

    @Override
    public void updateWarp(String world, Location location) {
        this.location = location;
    }

    @Override
    public void removeWarp(String warp) {

    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}