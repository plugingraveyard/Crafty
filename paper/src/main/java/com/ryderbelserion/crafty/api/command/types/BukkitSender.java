package com.ryderbelserion.crafty.api.command.types;

import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import com.ryderbelserion.crafty.common.api.engine.command.types.Sender;
import net.kyori.adventure.audience.Audience;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;
import java.util.UUID;

public class BukkitSender extends Sender {

    public static @NotNull Sender create(@NotNull CommandSender sender) {
        if (sender instanceof org.bukkit.entity.Player) {
            return new Player(sender);
        }

        return new BukkitSender(sender);
    }

    public BukkitSender(@NotNull CommandSender sender) {
        super(sender);
    }

    @Override
    @SuppressWarnings("unchecked")
    public @NotNull CommandSender getSender() {
        return super.getSender();
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        BukkitSender other = (BukkitSender) o;

        return getSender() == other.getSender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender());
    }

    @Override
    public @NotNull String toString() {
        return "BukkitSender{" + "sender=" + getSender().getName() + "}";
    }

    public static class Player extends BukkitSender implements Audience, Sender.Player<org.bukkit.entity.Player> {

        public Player(@NotNull CommandSender sender) {
            super(sender);
        }

        @Override
        public org.bukkit.entity.@NotNull Player getPlayer() {
            return (org.bukkit.entity.Player) getSender();
        }

        @Override
        public @NotNull Audience audience() {
            return CraftyPlugin.get().adventure().player(getPlayer().getUniqueId());
        }

        @Override
        public @NotNull UUID getUUID() {
            return getPlayer().getUniqueId();
        }

        @Override
        public @NotNull String toString() {
            return "BukkitSender$Player{" + "player=" + getPlayer().getUniqueId() + "}";
        }
    }
}