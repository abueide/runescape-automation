package archbots.kotlintemplate

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf

class TemplateRoot: BranchTask(){
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask = UnitLeaf(this)
    override fun successTask(): TreeTask  = UnitLeaf(this)
}