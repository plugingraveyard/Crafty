package com.ryderbelserion.crafty.api.enums;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;
import java.util.HashMap;

public enum Permissions {

    PLAYER_HELP("crafty.player.help", "Shows player only commands.", null, PermissionDefault.FALSE),
    ADMIN_HELP("crafty.admin.help", "Shows admin only commands with player only commands.", null, PermissionDefault.FALSE);

    private final String node;
    private final String desc;

    private final HashMap<String, Boolean> children;

    private final PermissionDefault permissionDefault;

    Permissions(String node, String desc, HashMap<String, Boolean> children, PermissionDefault permissionDefault) {
        this.node = node;
        this.desc = desc;
        this.children = children;
        this.permissionDefault = permissionDefault;
    }

    public String getNode() {
        return node;
    }

    public String getDesc() {
        return desc;
    }

    public HashMap<String, Boolean> getChildren() {
        return children;
    }

    public PermissionDefault getPermissionDefault() {
        return permissionDefault;
    }

    @Override
    public String toString() {
        return "crafty." + this.node;
    }

    public static void setup(PluginManager pluginManager) {
        for (Permissions action : Permissions.values()) {

            String node = action.getNode();
            String desc = action.getDesc();
            PermissionDefault permDefault = action.getPermissionDefault();
            HashMap<String, Boolean> children = action.getChildren();

            if (pluginManager.getPermission(node) == null) return;

            Permission permission = new Permission(
                    node,
                    desc,
                    permDefault,
                    children
            );

            pluginManager.addPermission(permission);
        }
    }
}