package militarymod

import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema

object MilitaryConfig {
    @JvmField
    val CLIENT = Client()

    @JvmField
    val SERVER = Server()

    class Client

    class Server {
        @JsonSchema(description = "The Force multiplier of jet engines")
        var JetEnginePowerMultiplyer = 1
    }
}