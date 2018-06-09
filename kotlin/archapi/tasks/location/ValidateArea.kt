package archapi.tasks.location

import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.script.framework.tree.BranchTask
import com.runemate.game.api.script.framework.tree.TreeTask

class ValidateArea(val area: Area, val success: TreeTask): BranchTask() {
    override fun validate(): Boolean = area.contains(Players.getLocal())
    override fun failureTask(): TreeTask = WalkTo(area)
    override fun successTask(): TreeTask = success
}