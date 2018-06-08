package archbots.archmage.treebot.leaves

import archbots.nullmage.NullMage
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import archapi.treebot.framework.LeafTask

class SelectCurse : LeafTask() {
    override fun execute() {
        Magic.STUN.activate()
        NullMage.lastSpell = false
    }
}
