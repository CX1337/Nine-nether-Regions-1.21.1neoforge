package com.cx1337.nine_nether_regions.item;

import com.cx1337.nine_nether_regions.NineNetherRegions;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    //木制盔甲
    public static final Holder<ArmorMaterial> WOOD_ARMOR_MATERIAL = register("wood",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 1);
                attribute.put(ArmorItem.Type.CHESTPLATE, 2);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 1);
            }), 4, 0.0F, 0.0F, () -> Items.STICK,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "wood"));

    //樱花盔甲
    public static final Holder<ArmorMaterial> CHERRY_ARMOR_MATERIAL = register("cherry",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 1);
                attribute.put(ArmorItem.Type.CHESTPLATE, 2);
                attribute.put(ArmorItem.Type.HELMET, 1);
                attribute.put(ArmorItem.Type.BODY, 1);
            }), 4, 0.0F, 0.0F, () -> ModItems.CHERRY_STICK.get(),
            SoundEvents.ARMOR_EQUIP_LEATHER,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "cherry"));

    //铜盔甲
    public static final Holder<ArmorMaterial> COPPER_ARMOR_MATERIAL = register("copper",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 3);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 4);
            }), 8, 0.0F, 0.0F, () -> Items.COPPER_INGOT,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "copper"));

    //精钢盔甲
    public static final Holder<ArmorMaterial> STEEL_ARMOR_MATERIAL = register("steel",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 12);
            }), 15, 3.0F, 0.2F, () -> ModItems.STEEL_INGOT.get(),
            SoundEvents.ARMOR_EQUIP_IRON,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "steel"));

    //虹宝石盔甲
    public static final Holder<ArmorMaterial> RAINBOWGEM_ARMOR_MATERIAL = register("rainbowgem",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 15);
            }), 17, 2.5F, 0.3F, () -> ModItems.RAINBOWGEM.get(),
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "rainbowgem"));

    //虚空合金盔甲。
    public static final Holder<ArmorMaterial> VOIDRITE_ARMOR_MATERIAL = register("voidrite",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 17);
            }), 19, 3.0F, 0.4F, () -> ModItems.VOIDRITE_INGOT.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "voidrite"));

    //幽冥合金盔甲
    public static final Holder<ArmorMaterial> HELLALLOY_ARMOR_MATERIAL = register("hellalloy",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 22);
            }), 28, 4.0F, 0.7F, () -> ModItems.HELLALLOY_INGOT.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "hellalloy"));

    //冥河盔甲
    public static final Holder<ArmorMaterial> STYX_ARMOR_MATERIAL = register("styx",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 9);
                attribute.put(ArmorItem.Type.CHESTPLATE, 11);
                attribute.put(ArmorItem.Type.HELMET, 6);
                attribute.put(ArmorItem.Type.BODY, 26);
            }), 34, 5.0F, 1.0F, () -> ModItems.STYX_INGOT.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, "styx"));

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem, Holder<SoundEvent> equipSound,
                                                  ResourceLocation texture) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(NineNetherRegions.MODID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(texture));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

}
