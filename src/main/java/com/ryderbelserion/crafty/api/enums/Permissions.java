package com.ryderbelserion.crafty.api.enums;

import com.ryderbelserion.crafty.api.utils.Constants;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;
import java.util.HashMap;

public enum Permissions {

    CRAFTY_HELP("help", "Allows access to the /crafty help command.", null, PermissionDefault.FALSE),
    CRAFTY_BASE("base", "Allows access to the base /crafty command.", null, PermissionDefault.FALSE),
    CRAFTY_RELOAD("reload", "Allows access to the /crafty reload command.", null, PermissionDefault.FALSE),
    CRAFTY_MESSAGE("message", "Gives the ability to send messages to others.", null, PermissionDefault.FALSE);

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
        return Constants.BASE_PERM + this.node;
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