package archapi.treebot.tasks.patterns

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask


open class Checker(val validation: Boolean, val failure: TreeTask, val success: TreeTask): BranchTask() {
    override fun validate(): Boolean = validation
    override fun failureTask(): TreeTask = failure;
    override fun successTask(): TreeTask = success
}