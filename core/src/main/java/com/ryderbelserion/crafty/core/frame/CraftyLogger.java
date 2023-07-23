package com.ryderbelserion.crafty.core.frame;

import com.ryderbelserion.crafty.core.frame.utils.AdventureUtils;

public class CraftyLogger {

    public static void debug(String message) {
        debug(message, null);
    }

    public static void debug(String message, Exception exception) {
        log(CraftyCore.api().getConsolePrefix() + "<yellow>[DEBUG]</yellow> " + message);

        if (exception != null) exception.printStackTrace();
    }

    public static void info(String message) {
        log(CraftyCore.api().getConsolePrefix() + "<dark_aqua>[INFO]</dark_aqua> " + message);
    }

    public static void severe(String message) {
        severe(message, null);
    }

    public static void severe(String message, Exception exception) {
        log(CraftyCore.api().getConsolePrefix() + "<red>[ERROR]</red> " + message);

        if (exception != null) exception.printStackTrace();
    }

    public static void warn(String message) {
        warn(message, null);
    }

    public static void warn(String message, Exception exception) {
        log(CraftyCore.api().getConsolePrefix() + "<yellow>[WARN]</yellow> " + message);

        if (exception != null) exception.printStackTrace();
    }

    private static void log(String message) {
       CraftyCore.api().adventure().sendMessage(AdventureUtils.parse(message));
    }
}