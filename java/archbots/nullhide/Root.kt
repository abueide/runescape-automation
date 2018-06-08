package archbots.nullhide

import com.runemate.game.api.script.framework.tree.BranchTask
import archapi.treebot.tasks.location.ValidateArea
import archbots.nullhide.branches.IsCrafterPlaced
import archbots.nullhide.util.PrefWrapper

class Root: BranchTask() {
    val validateArea = ValidateArea(PrefWrapper.getArea(), IsCrafterPlaced())
    override fun validate() = true;
    override fun failureTask() = null
    override fun successTask() =  validateArea
}