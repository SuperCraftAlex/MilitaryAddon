package militarymod.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.chat.ChatType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.server.commands.*
import net.minecraftforge.network.NetworkEvent


class ExampleCommand {
    companion object {
        fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
            dispatcher.register(Commands.literal("military").requires { commandSourceStack: CommandSourceStack ->
                commandSourceStack.hasPermission(0)
            }.then(Commands.argument("str",StringArgumentType.string()).executes { commandContext: CommandContext<CommandSourceStack> ->
                val strin = StringArgumentType.getString(commandContext,"str")
                val component1: Component =
                    TranslatableComponent("chat.type.announcement", "Name Display",strin)
                commandContext.source.playerOrException.sendMessage(component1,ChatType.SYSTEM,commandContext.source.playerOrException.uuid)
                1
            }))
        }
    }
}