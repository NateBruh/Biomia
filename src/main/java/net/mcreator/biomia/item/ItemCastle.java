
package net.mcreator.biomia.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.biomia.ElementsBiomia;

@ElementsBiomia.ModElement.Tag
public class ItemCastle extends ElementsBiomia.ModElement {
	@GameRegistry.ObjectHolder("biomia:castle")
	public static final Item block = null;
	public ItemCastle(ElementsBiomia instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("biomia:castle", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("castle", ElementsBiomia.sounds.get(new ResourceLocation("biomia:castle")));
			setUnlocalizedName("castle");
			setRegistryName("castle");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
