package militarymod.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.network.chat.ChatType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent


object ExampleCommand {
    fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
        dispatcher.register(Commands.literal("military").requires { commandSourceStack: CommandSourceStack ->
            commandSourceStack.hasPermission(0)
        }.then(Commands.argument("str",StringArgumentType.string()).executes { commandContext: CommandContext<CommandSourceStack> ->
            val component1: Component =
                TranslatableComponent("chat.type.announcement", "Name Display",StringArgumentType.getString(commandContext,"str"))
            commandContext.source.playerOrException.sendMessage(component1,ChatType.SYSTEM,commandContext.source.playerOrException.uuid)
            1
        }))
    }
}