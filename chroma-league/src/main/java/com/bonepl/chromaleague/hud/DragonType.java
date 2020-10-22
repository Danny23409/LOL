package com.bonepl.chromaleague.hud;

import com.bonepl.razersdk.animation.Color;

import java.util.Objects;

public enum DragonType {
    CLOUD("Air", Color.AIR),
    ELDER("Elder", Color.WHITE),
    INFERNAL("Fire", Color.RED),
    MOUNTAIN("Earth", Color.BROWN),
    OCEAN("Water", Color.OCEAN);

    private String apiType;
    private Color color;

    DragonType(String apiType, Color color) {
        this.apiType = apiType;
        this.color = color;
    }

    public String getApiType() {
        return apiType;
    }

    public Color getColor() {
        return color;
    }

    public static DragonType fromApiType(String apiType) {
        for (DragonType value : values()) {
            if (Objects.equals(value.getApiType(), apiType)) {
                return value;
            }
        }
        return null;
    }
}