package net.prangellplays.plasmasorigin.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.prangellplays.plasmasorigin.PlasmasOrigin;
import net.prangellplays.plasmasorigin.item.PlasmasToolMaterials;
import net.prangellplays.plasmasorigin.item.PlasmythicScytheItem;
import net.prangellplays.plasmasorigin.item.PlasmythicShieldItem;

public class PlasmasOriginItems {
    public static final Item PLASMYTHIC_SHIELD = registerItem("plasmythic_shield", new PlasmythicShieldItem(new FabricItemSettings().maxDamage(0).maxCount(1).fireproof()));
    public static final Item PLASMYTHIC_SCYTHE = registerItem("plasmythic_scythe", new PlasmythicScytheItem(PlasmasToolMaterials.THERMOSTATIC_STEEL, 7, -2.8f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item THERMOSTATIC_STEEL = registerItem("thermostatic_steel", new Item(new FabricItemSettings().fireproof()));

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(PLASMYTHIC_SHIELD);
        entries.add(PLASMYTHIC_SCYTHE);
        entries.add(THERMOSTATIC_STEEL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PlasmasOrigin.MOD_ID, name), item);
    }

    public static void registerPlasmasOriginItems() {
        PlasmasOrigin.LOGGER.info("Registering Mod Items for " + PlasmasOrigin.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(PlasmasOriginItems::addItemsToCombatItemGroup);
    }
}