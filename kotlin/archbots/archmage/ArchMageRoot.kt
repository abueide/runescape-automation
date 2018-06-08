package archbots.archmage

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask
import archbots.archmage.treebot.branches.IsAlchSelected
import archbots.archmage.treebot.leaves.Idle

class ArchMageRoot: BranchTask(){
    val idle = Idle()
    val isAlchSelected = IsAlchSelected()
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask =  idle
    override fun successTask(): TreeTask = isAlchSelected
}