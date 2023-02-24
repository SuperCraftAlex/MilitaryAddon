package militarymod.registries

import militarymod.MilitaryMod
import militarymod.commands.ExampleCommand
import net.minecraftforge.event.RegisterCommandsEvent

import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber(modid = MilitaryMod.modId, bus = Mod.EventBusSubscriber.Bus.FORGE)
object ModCommands {
    @SubscribeEvent
    fun onRegisterCommands(event: RegisterCommandsEvent) {
        ExampleCommand.register(event.dispatcher)
    }
}