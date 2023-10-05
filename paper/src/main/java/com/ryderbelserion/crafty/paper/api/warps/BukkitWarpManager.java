package com.ryderbelserion.crafty.paper.api.warps;

import com.ryderbelserion.crafty.api.warps.WarpManager;
import com.ryderbelserion.crafty.api.warps.records.Location;
import java.util.List;
import java.util.UUID;

public class BukkitWarpManager extends WarpManager {

    private Location location;
    private UUID creator;
    private UUID editor;

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
    public void setCreator(UUID uuid) {
        if (this.creator == null) this.creator = uuid;
    }

    @Override
    public UUID getCreator() {
        return this.creator;
    }

    @Override
    public void setEditor(UUID uuid) {
        if (this.editor == null) this.editor = uuid;
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