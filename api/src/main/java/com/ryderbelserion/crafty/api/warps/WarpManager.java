package com.ryderbelserion.crafty.api.warps;

import com.ryderbelserion.crafty.api.warps.records.Location;

import java.util.List;
import java.util.UUID;

public abstract class WarpManager {

    public abstract int x();

    public abstract int y();

    public abstract int z();

    public abstract float pitch();

    public abstract float yaw();

    public abstract String world();

    public abstract UUID setCreator(UUID uuid);

    public abstract UUID getCreator();

    public abstract UUID setEditor(UUID uuid);

    public abstract List<UUID> getEditors();

    public abstract void addWarp(String warp, Location location);

    public abstract void updateWarp(String world, Location location);

    public abstract void removeWarp(String warp);

    public abstract Location getLocation();

}