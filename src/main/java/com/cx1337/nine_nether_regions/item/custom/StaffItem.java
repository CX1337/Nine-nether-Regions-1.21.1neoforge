package com.cx1337.nine_nether_regions.item.custom;

public interface StaffItem {
    default int getCooldownOnMainHandUse() {
        return 10;
    }
}
