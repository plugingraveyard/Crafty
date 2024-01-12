package com.ryderbelserion.crafty.common.utils;

import net.kyori.adventure.text.format.TextColor;

public class ColorUtils {

    public static TextColor getColor(String color) {
        if (color == null || color.isBlank()) return null;

        try {
            String[] rgb = color.split(",");

            if (rgb.length != 3) return null;

            int red = Integer.parseInt(rgb[0]);
            int green = Integer.parseInt(rgb[1]);
            int blue = Integer.parseInt(rgb[2]);
            return TextColor.color(red, green, blue);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ignore) {}

        return null;
    }
}