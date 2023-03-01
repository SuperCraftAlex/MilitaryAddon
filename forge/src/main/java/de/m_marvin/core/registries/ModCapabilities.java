package de.m_marvin.core.registries;

import de.m_marvin.core.physics.engine.PhysicHandlerCapability;
import militarymod.MilitaryMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD,modid=MilitaryMod.modId)
public class ModCapabilities {
	public static final Capability<PhysicHandlerCapability> PHYSIC_DATA_HOLDER_CAPABILITY = CapabilityManager.get(new CapabilityToken<PhysicHandlerCapability>() {});
	
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE,modid=MilitaryMod.modId)
	public class Attachment {
		
		@SubscribeEvent
		public static void attachCapabilities(AttachCapabilitiesEvent<Level> event) {
			event.addCapability(new ResourceLocation(MilitaryMod.modId, "physics"), new PhysicHandlerCapability(event.getObject()));
		}
		
	}
	
}
