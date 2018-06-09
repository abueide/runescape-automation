package archbots.nullhide

import archapi.tasks.location.ValidateLocation
import archapi.treebot.BranchTask
import archapi.treebot.UnitLeaf
import archbots.nullhide.branches.IsCrafterPlaced
import archbots.nullhide.util.PrefWrapper

class Root: BranchTask() {
    val validateArea = ValidateLocation(PrefWrapper.getArea(), IsCrafterPlaced())
    override fun validate() = true;
    override fun failureTask() = UnitLeaf(this)
    override fun successTask() =  validateArea
}