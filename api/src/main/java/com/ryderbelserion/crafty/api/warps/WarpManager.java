package com.ryderbelserion.crafty.api.warps;

import com.ryderbelserion.crafty.api.warps.records.Location;
import java.util.List;
import java.util.UUID;

public abstract class WarpManager {

    /**
     * @return the x coordinate
     */
    public abstract int x();

    /**
     * @return the z coordinate
     */
    public abstract int y();

    /**
     * @return the z coordinate
     */
    public abstract int z();

    /**
     * @return the pitch
     */
    public abstract float pitch();

    /**
     * @return the yaw
     */
    public abstract float yaw();

    /**
     * @return the world name
     */
    public abstract String world();

    /**
     * Sets who created the warp
     *
     * @param uuid of the player
     */
    public abstract void setCreator(UUID uuid);

    /**
     * @return the creator of the warp
     */
    public abstract UUID getCreator();

    /**
     * Sets who has edited the warp since creation.
     *
     * @param uuid of the player
     */
    public abstract void setEditor(UUID uuid);

    /**
     * @return a list of editors who edited the warp.
     */
    public abstract List<UUID> getEditors();

    /**
     * Add warp to the world.
     *
     * @param warp - The warp to add.
     * @param location - The location data.
     */
    public abstract void addWarp(String warp, Location location);

    /**
     * Update the current warp if found otherwise add warp.
     *
     * @param warp - The warp to update.
     * @param location - The location data.
     */
    public abstract void updateWarp(String warp, Location location);

    /**
     * Remove the current warp if it exists.
     *
     * @param warp - The warp to remove.
     */
    public abstract void removeWarp(String warp);

    /**
     * @return the built location.
     */
    public abstract Location getLocation();

}