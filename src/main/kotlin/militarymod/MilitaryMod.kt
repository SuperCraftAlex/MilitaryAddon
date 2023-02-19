package militarymod

import com.mojang.logging.LogUtils
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod

@Mod("military")
class MilitaryMod {
    init {


        MinecraftForge.EVENT_BUS.register(this)
    }

    companion object {
        private val LOGGER = LogUtils.getLogger()
    }
}
