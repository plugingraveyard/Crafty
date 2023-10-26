package com.ryderbelserion.crafty.paper.api.managers;

import com.ryderbelserion.crafty.common.config.persist.Settings;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class CombatManager {

    public static void adjustAttackSpeed(Player player) {
        if (!Settings.hit_delay_toggle) {
            setAttackSpeed(player, 4.0);
            return;
        }

        World world = player.getWorld();

        double speed = Settings.worlds.contains(world.getName()) ? Settings.hit_delay : 4.0;

        setAttackSpeed(player, speed);
    }

    public static void setAttackSpeed(Player player, double speed) {
        AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);

        if (attribute == null) return;

        double baseValue = attribute.getBaseValue();

        if (baseValue != speed) {
            attribute.setBaseValue(speed);

            player.saveData();
        }
    }
}