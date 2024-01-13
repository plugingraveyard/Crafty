package me.corecraft.crafty.api;

import ch.jalu.configme.SettingsManager;
import com.ryderbelserion.crafty.common.api.interfaces.AbstractPlugin;
import com.ryderbelserion.crafty.common.config.ConfigFactory;
import net.kyori.adventure.platform.AudienceProvider;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class PaperAbstractPlugin extends AbstractPlugin {

    private final File file;

    private BukkitAudiences adventure;

    private ConfigFactory factory;

    public PaperAbstractPlugin(File file, JavaPlugin plugin) {
        // Initialize an audience instance for the plugin.
        this.adventure = BukkitAudiences.create(plugin);

        this.file = file;
    }

    @Override
    public void init() {
        super.enable();

        this.factory = new ConfigFactory();
        this.factory.load();
    }

    @Override
    public void stop() {
        super.disable();

        this.factory.reload();

        if (this.adventure != null) {
            this.adventure.close();
            this.adventure = null;
        }
    }

    @Override
    public void reload() {
        this.factory.reload();
    }

    @Override
    public File getDataFolder() {
        return this.file;
    }

    @Override
    public SettingsManager getConfig() {
        return this.factory.getConfig();
    }

    @Override
    public SettingsManager getLocale() {
        return this.factory.getMessages();
    }

    @Override
    public AudienceProvider adventure() {
        if (this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }

        return this.adventure;
    }
}