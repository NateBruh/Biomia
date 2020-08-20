
package net.mcreator.biomia.block;

@ElementsBiomia.ModElement.Tag
public class BlockWastelandSand extends ElementsBiomia.ModElement {

	@GameRegistry.ObjectHolder("biomia:wastelandsand")
	public static final Block block = null;

	public BlockWastelandSand(ElementsBiomia instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("wastelandsand"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("biomia:wastelandsand", "inventory"));

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
		if (!biomeCriteria)
			return;

		for (int i = 0; i < 10; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(25) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 16, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}

	public static class BlockCustom extends BlockFalling {

		public BlockCustom() {
			super(Material.SAND);

			setUnlocalizedName("wastelandsand");
			setSoundType(SoundType.SAND);

			setHardness(0.75F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabBiomiaBaseTab.tab);

		}

		@Override
		public EnumPushReaction getMobilityFlag(IBlockState state) {
			return EnumPushReaction.DESTROY;
		}

		@Override
		public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
			return false;
		}

		@Override
		public int quantityDropped(Random random) {
			return 0;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
			super.randomDisplayTick(state, world, pos, random);
			EntityPlayer entity = Minecraft.getMinecraft().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			int i = x;
			int j = y;
			int k = z;
			if (true)
				for (int l = 0; l < 0; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 1D;
					double d4 = (random.nextFloat() - 0.5D) * 1D;
					double d5 = (random.nextFloat() - 0.5D) * 1D;
					world.spawnParticle(EnumParticleTypes.CLOUD, d0, d1, d2, d3, d4, d5);
				}
		}

	}

}
