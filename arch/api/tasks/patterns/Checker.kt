package arch.api.tasks.patterns

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask


open class Checker(val validation: Boolean, val failure: TreeTask, val success: TreeTask) : BranchTask() {
    override fun validate(): Boolean = validation
    override fun failureTask(): TreeTask = failure;
    override fun successTask(): TreeTask = success
}