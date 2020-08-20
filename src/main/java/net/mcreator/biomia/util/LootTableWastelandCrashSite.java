
package net.mcreator.biomia.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.biomia.ElementsBiomia;

@ElementsBiomia.ModElement.Tag
public class LootTableWastelandCrashSite extends ElementsBiomia.ModElement {
	public LootTableWastelandCrashSite(ElementsBiomia instance) {
		super(instance, 9);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("biomia", "crashsite"));
	}
}
