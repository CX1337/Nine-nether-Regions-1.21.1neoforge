package com.cx1337.nine_nether_regions.item.curios;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForge;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ModCurios extends Item implements ICurioItem {
    String attributeSlot = "";
    Function<Integer, Multimap<Holder<Attribute>, AttributeModifier>> attributes = null;
    Map<String, Integer> slotModifiers = new HashMap<>();
    public ModCurios(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext,
                                                                                ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = LinkedHashMultimap.create();
        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            modifiers.putAll(this.attributes.apply(slotContext.index()));
        }
        if (!this.slotModifiers.isEmpty()) {
            this.slotModifiers.forEach((slotId, amount) -> {
                CuriosApi.addSlotModifier(modifiers, slotId, id, amount, AttributeModifier.Operation.ADD_VALUE);
            });
        }
        CurioAttributeModifierEvent evt =
                new CurioAttributeModifierEvent(stack, slotContext, id, modifiers);
        NeoForge.EVENT_BUS.post(evt);
        return modifiers;
    }
}
