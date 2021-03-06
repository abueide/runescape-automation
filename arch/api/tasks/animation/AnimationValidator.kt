package arch.api.tasks.animation

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import com.runemate.game.api.hybrid.region.Players

class AnimationValidator(val id: Int, val invert: Boolean, val failure: TreeTask, val success: TreeTask) : BranchTask() {
    constructor(id: Int, failure: TreeTask, success: TreeTask) : this(id, false, failure, success)

    override fun failureTask(): TreeTask = failure

    override fun successTask(): TreeTask = success

    override fun validate(): Boolean = invert `xor` (Players.getLocal().animationId == id)
}