package nullapi.treeframework

import com.runemate.game.api.script.framework.tree.BranchTask
import com.runemate.game.api.script.framework.tree.TreeTask

open class Validator(val validation: Boolean, val failure: TreeTask, val success: TreeTask): BranchTask() {
    override fun validate(): Boolean = validation
    override fun failureTask(): TreeTask = failure;
    override fun successTask(): TreeTask = success
}