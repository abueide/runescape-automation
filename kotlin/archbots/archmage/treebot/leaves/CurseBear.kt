package archbots.archmage.treebot.leaves

import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import archapi.treebot.framework.LeafTask

class CurseBear : LeafTask() {
    override fun execute() {
//        Npcs.newQuery().names("Grizzly bear").results().nearest().click();
//        Magic.CAMELOT_TELEPORT.activate()
        Magic.WIND_STRIKE.activate()
    }
}
