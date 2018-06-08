package archbots.archmage.treebot.branches

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.TreeTask
import archbots.archmage.treebot.leaves.SelectAlch
import archbots.archmage.treebot.leaves.SelectCurse

class ChooseSpell : BranchTask() {

    private val selectAlch = SelectAlch()
    private val selectCurse = SelectCurse()

    override fun successTask(): TreeTask {
        return selectCurse
    }

    override fun failureTask(): TreeTask {
        return selectAlch
    }

    override fun validate(): Boolean {
        return true;
    }
}
