package archbots.archmage.treebot.branches

import archbots.archmage.treebot.leaves.AlchItem
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask

class IsAlchSelected : BranchTask() {

    private val alchItem = AlchItem()
    private val isCurseSelected = IsCurseSelected()

    override fun successTask(): TreeTask {
        return alchItem
    }

    override fun failureTask(): TreeTask {
        return isCurseSelected
    }

    override fun validate(): Boolean {
        return Magic.HIGH_LEVEL_ALCHEMY.isSelected
    }
}
