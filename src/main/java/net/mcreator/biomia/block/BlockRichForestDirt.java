
package net.mcreator.biomia.block;

@ElementsBiomia.ModElement.Tag
public class BlockRichForestDirt extends ElementsBiomia.ModElement {

	@GameRegistry.ObjectHolder("biomia:richforestdirt")
	public static final Block block = null;

	public BlockRichForestDirt(ElementsBiomia instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("richforestdirt"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("biomia:richforestdirt", "inventory"));

	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;

		if (dimID == 0)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("biomia:richforest")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		for (int i = 0; i < 10; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(128) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 16, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					require = Blocks.DIRT.getStateFromMeta(0);
					try {
						if ((blockAt.getBlock() == require.getBlock())
								&& (blockAt.getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require)))
							blockCriteria = true;
					} catch (Exception e) {
						if (blockAt.getBlock() == require.getBlock())
							blockCriteria = true;
					}
					require = Blocks.STONE.getStateFromMeta(0);
					try {
						if ((blockAt.getBlock() == require.getBlock())
								&& (blockAt.getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require)))
							blockCriteria = true;
					} catch (Exception e) {
						if (blockAt.getBlock() == require.getBlock())
							blockCriteria = true;
					}
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GROUND);

			setUnlocalizedName("richforestdirt");
			setSoundType(SoundType.GROUND);

			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabBiomiaBaseTab.tab);

		}

		@Override
		public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
				net.minecraftforge.common.IPlantable plantable) {
			return true;
		}

	}

}
