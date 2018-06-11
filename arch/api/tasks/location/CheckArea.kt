package arch.api.tasks.location

import arch.api.tasks.patterns.Checker
import arch.api.treebot.TreeTask
import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.region.Players

class CheckArea(val area: Area, failure: TreeTask, success: TreeTask) : Checker(area.contains(Players.getLocal()), failure, success) {}