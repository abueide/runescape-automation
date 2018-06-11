package arch.bots.nullhide

import arch.api.tasks.location.ValidateLocation
import arch.api.treebot.BranchTask
import arch.api.treebot.UnitLeaf
import arch.bots.nullhide.branches.IsCrafterPlaced
import arch.bots.nullhide.util.PrefWrapper

class Root: BranchTask() {
    val validateArea = ValidateLocation(PrefWrapper.getArea(), IsCrafterPlaced())
    override fun validate() = true;
    override fun failureTask() = UnitLeaf(this)
    override fun successTask() =  validateArea
}