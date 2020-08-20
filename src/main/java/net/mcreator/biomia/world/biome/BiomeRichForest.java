
package net.mcreator.biomia.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;

import net.mcreator.biomia.block.BlockRichForestGrassBlock;
import net.mcreator.biomia.block.BlockRichForestDirt;
import net.mcreator.biomia.ElementsBiomia;

import java.util.Random;

@ElementsBiomia.ModElement.Tag
public class BiomeRichForest extends ElementsBiomia.ModElement {
	@GameRegistry.ObjectHolder("biomia:richforest")
	public static final BiomeGenCustom biome = null;
	public BiomeRichForest(ElementsBiomia instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 100));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Rich Forest").setRainfall(0.6F).setBaseHeight(0.13F).setWaterColor(-14325985).setHeightVariation(0.2F)
					.setTemperature(0.7F));
			setRegistryName("richforest");
			topBlock = BlockRichForestGrassBlock.block.getDefaultState();
			fillerBlock = BlockRichForestDirt.block.getDefaultState();
			decorator.generateFalls = true;
			decorator.treesPerChunk = 5;
			decorator.flowersPerChunk = 9;
			decorator.grassPerChunk = 4;
			decorator.deadBushPerChunk = 1;
			decorator.mushroomsPerChunk = 3;
			decorator.bigMushroomsPerChunk = 1;
			decorator.reedsPerChunk = 2;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 2;
			decorator.gravelPatchesPerChunk = 2;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return BIG_TREE_FEATURE;
		}
	}
}
