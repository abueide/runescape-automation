package arch.bots.kotlintemplate

import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.hybrid.region.Players

class TemplateRoot : BranchTask() {
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask = UnitLeaf(this)
    override fun successTask(): TreeTask = InlineLeafTask{logger.debug(Players.getLocal().animationFrame)}
}