package com.ryderbelserion.crafty.paper.modules.types;

import com.ryderbelserion.crafty.common.config.persist.SettingsHandler;
import com.ryderbelserion.crafty.paper.Crafty;
import com.ryderbelserion.crafty.paper.api.interfaces.ModuleHandler;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.jetbrains.annotations.NotNull;

public class HitDelayModule extends ModuleHandler {

    @NotNull
    private final Crafty plugin = Crafty.get();

    @NotNull
    private final SettingsHandler settings = this.plugin.getConfigManager().getSettings();

    @Override
    public String getModuleName() {
        return "Hit Delay Module";
    }

    @Override
    public boolean isEnabled() {
        return this.settings.isHitDelayEnabled();
    }

    @Override
    public void reload() {
        this.plugin.getServer().getOnlinePlayers().forEach(this::adjustAttackSpeed);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        adjustAttackSpeed(player);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        adjustAttackSpeed(player);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        setAttackSpeed(player, 4.0);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        adjustAttackSpeed(player);
    }

    private void adjustAttackSpeed(Player player) {
        if (!isEnabled()) {
            setAttackSpeed(player, 4.0);
            return;
        }

        World world = player.getWorld();

        double speed = this.settings.getWorldList().contains(world.getName()) ? this.settings.getHitDelay() : 4.0;

        setAttackSpeed(player, speed);
    }

    private void setAttackSpeed(Player player, double speed) {
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);

        if (attribute == null) return;

        double baseValue = attribute.getBaseValue();

        if (baseValue != speed) {
            attribute.setBaseValue(speed);

            player.saveData();
        }
    }
}