package archbots.archmage.treebot.branches

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask
import archbots.archmage.treebot.leaves.Idle
import com.runemate.game.api.hybrid.region.Players

class AnimationValidator(val id: Int, val invert: Boolean, val failure: TreeTask, val success: TreeTask) : BranchTask() {
    constructor(id: Int, failure: TreeTask, success: TreeTask) : this(id, false, failure, success)

    override fun failureTask(): TreeTask = Idle()

    override fun successTask(): TreeTask = success

    override fun validate(): Boolean = invert `xor` (Players.getLocal().animationId == id)
}