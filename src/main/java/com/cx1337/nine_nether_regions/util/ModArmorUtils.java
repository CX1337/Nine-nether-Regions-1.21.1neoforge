package com.cx1337.nine_nether_regions.util;

import com.cx1337.nine_nether_regions.item.custom.HellalloyBoots;
import com.cx1337.nine_nether_regions.item.custom.HellalloyChestplate;
import com.cx1337.nine_nether_regions.item.custom.HellalloyHelmet;
import com.cx1337.nine_nether_regions.item.custom.HellalloyLeggings;
import com.cx1337.nine_nether_regions.item.custom.StyxBoots;
import com.cx1337.nine_nether_regions.item.custom.StyxChestplate;
import com.cx1337.nine_nether_regions.item.custom.StyxHelmet;
import com.cx1337.nine_nether_regions.item.custom.StyxLeggings;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

public class ModArmorUtils {
    public static boolean hasFullHellalloyArmor(Player player) {
        return player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof HellalloyBoots &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof HellalloyLeggings &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof HellalloyChestplate &&
                player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof HellalloyHelmet;
    }

    public static boolean hasFullStyxArmor(Player player){
        return player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof StyxBoots &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof StyxLeggings &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof StyxChestplate &&
                player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof StyxHelmet;
    }
}
