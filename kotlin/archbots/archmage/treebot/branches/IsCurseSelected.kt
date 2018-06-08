package archbots.archmage.treebot.branches

import archbots.archmage.treebot.leaves.CurseBear
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask

class IsCurseSelected : BranchTask() {

    private val chooseSpell = ChooseSpell()
    private val curseBear = CurseBear()

    override fun successTask(): TreeTask {
        return curseBear
    }

    override fun failureTask(): TreeTask {
        return chooseSpell
    }

    override fun validate(): Boolean {
        return Magic.STUN.isSelected
    }
}
