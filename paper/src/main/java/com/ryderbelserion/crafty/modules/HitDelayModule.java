package com.ryderbelserion.crafty.modules;

import com.ryderbelserion.cluster.utils.modules.ModuleHandler;
import com.ryderbelserion.crafty.common.config.types.modules.HitDelayConfig;
import com.ryderbelserion.crafty.Crafty;
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

    @Override
    public String getModuleName() {
        return "Hit Delay Module";
    }

    @Override
    public boolean isEnabled() {
        return CraftyPlugin.getConfig().getProperty(HitDelayConfig.toggle);
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

        double speed = CraftyPlugin.getConfig().getProperty(HitDelayConfig.worlds).contains(world.getName()) ? CraftyPlugin.getConfig().getProperty(HitDelayConfig.speed) : 4.0;

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