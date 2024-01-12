package com.ryderbelserion.crafty.common.api.engine.command.types;

import com.ryderbelserion.crafty.common.api.CraftyPlugin;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.ForwardingAudience;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

/**
 * Represents a command sender.
 */
public abstract class Sender implements ForwardingAudience.Single {

    private final Object sender;

    public <T> Sender(@NotNull T sender) {
        this.sender = sender;
    }

    @SuppressWarnings("unchecked")
    public <T> @NotNull T getSender() {
        return (T) this.sender;
    }

    @Override
    public @NotNull Audience audience() {
        return CraftyPlugin.get().adventure().console();
    }

    public void sendMessage(@NotNull ComponentLike message) {
        audience().sendMessage(message);
    }

    @Override
    public abstract boolean equals(@Nullable Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract @NotNull String toString();

    public interface Player<T> {
        @NotNull T getPlayer();

        @NotNull UUID getUUID();
    }
}
