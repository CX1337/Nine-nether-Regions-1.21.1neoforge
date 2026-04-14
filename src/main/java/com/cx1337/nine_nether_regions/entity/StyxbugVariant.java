package com.cx1337.nine_nether_regions.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum StyxbugVariant {
    RED(0),
    GREEN(1);

    private static final StyxbugVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(StyxbugVariant :: getId)).toArray(StyxbugVariant[]::new);
    private final int id;

    StyxbugVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static StyxbugVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
