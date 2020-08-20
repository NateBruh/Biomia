
package net.mcreator.biomia.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;

import net.mcreator.biomia.block.BlockWastelandStandstone;
import net.mcreator.biomia.block.BlockWastelandSand;
import net.mcreator.biomia.ElementsBiomia;

import java.util.Random;

@ElementsBiomia.ModElement.Tag
public class BiomeWasteland extends ElementsBiomia.ModElement {
	@GameRegistry.ObjectHolder("biomia:wasteland")
	public static final BiomeGenCustom biome = null;
	public BiomeWasteland(ElementsBiomia instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 15));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Wasteland").setRainfall(0.25F).setBaseHeight(0.1F).setWaterColor(-9670795).setHeightVariation(0.25F)
					.setTemperature(1F));
			setRegistryName("wasteland");
			topBlock = BlockWastelandSand.block.getDefaultState();
			fillerBlock = BlockWastelandStandstone.block.getDefaultState();
			decorator.generateFalls = false;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 5;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -8816263;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -8816263;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -2696736;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
