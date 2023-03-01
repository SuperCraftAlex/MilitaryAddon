package militarymod.registries

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import com.mojang.brigadier.context.CommandContext
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.network.chat.ChatType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent

object ModCommands {
    fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
        //Commands.literal is for standard command string inputs like /military or /military otherinput
        //hasPermission provides the permission level required for executing said command
        //Commands.argument can be used with several ArgumentTypes in order to provide a vast amount of potential in regard to commands
        //executes is what allows this command to actually execute
        dispatcher.register(Commands.literal("military").requires { commandSourceStack: CommandSourceStack ->
            commandSourceStack.hasPermission(0)
        }.then(Commands.argument("str",StringArgumentType.string()).executes { commandContext: CommandContext<CommandSourceStack> ->
            val component1: Component =
                TranslatableComponent("chat.type.announcement", "Name Display",StringArgumentType.getString(commandContext,"str"))
            commandContext.source.playerOrException.sendMessage(component1,ChatType.SYSTEM,commandContext.source.playerOrException.uuid)
            1
        }))
        //As long as dispatcher.register is used and the proper syntax is in place you can make many commands in one file.
        /*dispatcher.register(
            Commands.literal("name").requires {commandSourceStack: CommandSourceStack ->
                commandSourceStack.hasPermission(PermissionLevelAsAnInt)
          //Following this you can use .then for another command.argument or command.literal prior to ending with .executes once .executes is used the command should be pretty much finished.
            }.then(
          //Don't forget that you'll want the executes inside the outer parenthesis of then in order to use the then as an argument/literal.
                Commands.literal("test").then(
                //I don't know that many types, so I'll just example string.
                    Commands.argument("varname",StringArgumentType.string()).executes { commandContext: CommandContext<CommandSourceStack> ->
                        //Your code here:
                        //No idea what the 1 is for, just know that it's usually needed.
                        1
                    }
                )
            )
          )
         */
    }
}