package nullbots.nullhide

import com.runemate.game.api.script.framework.tree.BranchTask
import com.runemate.game.api.script.framework.tree.TreeTask
import nullapi.treeframework.location.ValidateArea
import nullbots.nullhide.branches.IsCrafterPlaced
import nullbots.nullhide.util.PrefWrapper

class Root: BranchTask() {
    val validateArea = ValidateArea(PrefWrapper.getArea(), IsCrafterPlaced())
    override fun validate() = true;
    override fun failureTask() = null
    override fun successTask() =  validateArea
}