package arch.api.tasks.location

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.location.Coordinate
import com.runemate.game.api.hybrid.region.Players

class ValidateLocation(val area: Area, val success: TreeTask) : BranchTask() {
    constructor(coordinate: Coordinate, success: TreeTask) : this(Area.Circular(coordinate, 5.0), success)

    override fun validate(): Boolean = area.contains(Players.getLocal())
    override fun failureTask(): TreeTask = WalkTo(area)
    override fun successTask(): TreeTask = success
}