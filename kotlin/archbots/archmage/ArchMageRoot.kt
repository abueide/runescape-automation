package archbots.archmage

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask
import archapi.treebot.framework.UnitLeaf
import archbots.archmage.treebot.leaves.Idle

class ArchMageRoot: BranchTask(){
    val idle = Idle()
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask =  idle
    override fun successTask(): TreeTask = UnitLeaf(this)
}