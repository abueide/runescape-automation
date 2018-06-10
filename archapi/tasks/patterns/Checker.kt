package archapi.tasks.patterns

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask


open class Checker(val validation: Boolean, val failure: TreeTask, val success: TreeTask): BranchTask() {
    override fun validate(): Boolean = validation
    override fun failureTask(): TreeTask = failure;
    override fun successTask(): TreeTask = success
}