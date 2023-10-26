package com.ryderbelserion.crafty.common.data;

import com.google.gson.annotations.Expose;

public record Location(@Expose String world, @Expose double x, @Expose double y, @Expose double z, @Expose float yaw, @Expose float pitch) {}