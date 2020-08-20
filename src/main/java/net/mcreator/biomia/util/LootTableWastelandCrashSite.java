
package net.mcreator.biomia.util;

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
