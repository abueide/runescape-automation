package archbots.archmage.treebot.leaves

import archbots.nullmage.NullMage
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import archapi.treebot.framework.LeafTask

class SelectAlch : LeafTask() {

    override fun execute() {
        Magic.HIGH_LEVEL_ALCHEMY.activate()
        NullMage.lastSpell = true
    }
}
