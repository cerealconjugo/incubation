package com.teamabnormals.incubation.core.registry;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.incubation.core.Incubation;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Incubation.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class IncubationStructures {

	public static void setupVillagerHouses() {
		PlainVillagePools.bootstrap();
		SnowyVillagePools.bootstrap();
		SavannaVillagePools.bootstrap();
		DesertVillagePools.bootstrap();
		TaigaVillagePools.bootstrap();

		addVillagerHouse("chicken_coop", "plains", 2);
		addVillagerHouse("chicken_coop", "snowy", 2);
		addVillagerHouse("chicken_coop", "savanna", 2);
		addVillagerHouse("chicken_coop", "desert", 2);
		addVillagerHouse("chicken_coop", "taiga", 2);

		Pools.register(new StructureTemplatePool(new ResourceLocation(Incubation.MOD_ID, "village/chickens"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(StructurePoolElement.legacy(Incubation.MOD_ID + ":village/chickens_1"), 1)), StructureTemplatePool.Projection.RIGID));
	}

	private static void addVillagerHouse(String type, String biome, int weight) {
		DataUtil.addToJigsawPattern(new ResourceLocation("village/" + biome + "/houses"), StructurePoolElement.single(Incubation.MOD_ID + ":village/" + biome + "_" + type + "_1").apply(StructureTemplatePool.Projection.RIGID), weight);
	}
}
