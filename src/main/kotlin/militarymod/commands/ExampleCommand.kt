package militarymod.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.network.chat.ChatType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent

class ExampleCommand {
    companion object {
        fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
            dispatcher.register(
                Commands.literal("military").requires { sourceStack: CommandSourceStack ->
                    //Player permission level:
                    sourceStack.hasPermission(
                        2
                    )
                }.executes { commandContext: CommandContext<CommandSourceStack> ->
                            val component1: Component =
                                TranslatableComponent("chat.type.announcement", "Name Display", "Testing 123")
                            commandContext.source.playerOrException.sendMessage(component1,ChatType.SYSTEM,commandContext.source.playerOrException.uuid)
                            1
                }
            )
        }
    }
}