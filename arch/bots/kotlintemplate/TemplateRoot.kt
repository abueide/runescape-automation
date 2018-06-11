package arch.bots.kotlintemplate

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf

class TemplateRoot : BranchTask() {
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask = UnitLeaf(this)
    override fun successTask(): TreeTask = UnitLeaf(this)
}