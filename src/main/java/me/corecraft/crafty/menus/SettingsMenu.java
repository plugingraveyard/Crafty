package me.corecraft.crafty.menus;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.corecraft.crafty.Crafty;
import me.corecraft.crafty.api.configs.types.PluginSettings;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import us.crazycrew.crazycore.utils.AdventureUtils;
import java.util.Arrays;

public class SettingsMenu {

    private static final Crafty plugin = Crafty.getPlugin();

    private static final MiniMessage mini = MiniMessage.miniMessage();
    private static final Gui gui = Gui.gui()

            .title(AdventureUtils.parse("<red>Crafty Settings</red>", false))
            .type(GuiType.CHEST)
            .disableAllInteractions()
            .rows(3)
            .create();

    private static final GuiItem reloadButton = ItemBuilder.from(Material.TURTLE_HELMET).name(AdventureUtils.parse("<light_purple>Reload Plugin</light_purple>", false)).asGuiItem(event -> {
        plugin.getApiLoader().getPluginSettings().reload();

        HumanEntity player = event.getWhoClicked();

        String prefix = plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX_TOGGLE) ? plugin.getApiLoader().getPluginSettings().getProperty(PluginSettings.COMMAND_PREFIX) : "";

        player.sendMessage(MiniMessage.miniMessage().deserialize(prefix + "You have reloaded the plugin."));
    });

    public static void open(Player player) {
        gui.getFiller().fill(Arrays.asList(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).name(Component.text("")).asGuiItem(), ItemBuilder.from(Material.WHITE_STAINED_GLASS_PANE).name(Component.text("")).asGuiItem()));

        gui.setItem(2, 5, reloadButton);

        gui.open(player);
    }

    public static void update() {
        gui.update();
    }
}