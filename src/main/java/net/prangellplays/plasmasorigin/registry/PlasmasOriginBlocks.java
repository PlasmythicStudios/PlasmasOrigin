package net.prangellplays.plasmasorigin.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.prangellplays.plasmasorigin.PlasmasOrigin;
import net.prangellplays.plasmasorigin.world.tree.PlasmythicSaplingGenerator;

public class PlasmasOriginBlocks {

    public static final Block PLASMYTHIC_LEAVES = registerBlock("plasmythic_leaves",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.2f).nonOpaque().sounds(BlockSoundGroup.CHERRY_LEAVES)), ItemGroups.NATURAL);
    public static final Block PLASMYTHIC_PLANKS = registerBlock("plasmythic_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).sounds(BlockSoundGroup.WOOD).strength(4.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ItemGroups.BUILDING_BLOCKS);
    public static final Block PLASMYTHIC_LOG = registerBlock("plasmythic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).sounds(BlockSoundGroup.WOOD).strength(4.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ItemGroups.BUILDING_BLOCKS);
    public static final Block PLASMYTHIC_WOOD = registerBlock("plasmythic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE).sounds(BlockSoundGroup.WOOD).strength(4.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ItemGroups.BUILDING_BLOCKS);
    public static final Block STRIPPED_PLASMYTHIC_LOG = registerBlock("stripped_plasmythic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).sounds(BlockSoundGroup.WOOD).strength(4.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ItemGroups.BUILDING_BLOCKS);
    public static final Block STRIPPED_PLASMYTHIC_WOOD = registerBlock("stripped_plasmythic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).sounds(BlockSoundGroup.WOOD).strength(4.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ItemGroups.BUILDING_BLOCKS);
    public static final Block PLASMYTHIC_SAPLING = registerBlock("plasmythic_sapling",
            new SaplingBlock(new PlasmythicSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ItemGroups.NATURAL);


    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(PlasmasOrigin.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(PlasmasOrigin.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerPlasmasOriginBlocks() {
        PlasmasOrigin.LOGGER.info("Registering ModBlocks for " + PlasmasOrigin.MOD_ID);
    }
}
