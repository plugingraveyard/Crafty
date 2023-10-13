package com.ryderbelserion.crafty.api.warps;

import com.ryderbelserion.crafty.api.warps.records.CustomLocation;

import java.util.List;
import java.util.UUID;

public abstract class SpawnManager {

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
     * Sets who created the spawn
     *
     * @param uuid of the player
     */
    public abstract void setCreator(UUID uuid);

    /**
     * @return the creator of the spawn
     */
    public abstract UUID getCreator();

    /**
     * Sets who has edited the spawn since creation.
     *
     * @param uuid of the player
     */
    public abstract void setEditor(UUID uuid);

    /**
     * @return a list of editors who edited the spawn.
     */
    public abstract List<UUID> getEditors();

    /**
     * Add spawn to the world.
     *
     * @param world - The world where the spawn is.
     * @param customLocation - The location data.
     */
    public abstract void addSpawn(String world, CustomLocation customLocation);

    /**
     * Update the current spawn if found otherwise add spawn.
     *
     * @param world - The world where the spawn is.
     * @param customLocation - The location data.
     */
    public abstract void updateSpawn(String world, CustomLocation customLocation);

    /**
     * Remove the current spawn if it exists.
     *
     * @param world - The world where the spawn is.
     */
    public abstract void removeSpawn(String world);

    /**
     * @return the built location.
     */
    public abstract CustomLocation getLocation();

}