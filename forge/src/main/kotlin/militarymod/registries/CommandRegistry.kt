package militarymod.registries

import militarymod.MilitaryMod
import net.minecraftforge.event.RegisterCommandsEvent

import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber(modid = MilitaryMod.modId, bus = Mod.EventBusSubscriber.Bus.FORGE)
object CommandRegistry {
    @SubscribeEvent
    fun onRegisterCommands(event: RegisterCommandsEvent) {
        ModCommands.register(event.dispatcher)
    }
}