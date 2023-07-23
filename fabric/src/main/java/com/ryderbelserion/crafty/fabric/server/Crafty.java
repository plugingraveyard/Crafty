package com.ryderbelserion.crafty.fabric.server;

import net.fabricmc.api.DedicatedServerModInitializer;

public class Crafty implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        System.out.println("Guten Tag!");
    }
}