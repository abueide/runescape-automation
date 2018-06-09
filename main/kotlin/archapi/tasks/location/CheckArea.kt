package archapi.tasks.location

import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.region.Players
import archapi.tasks.patterns.Checker
import archapi.treebot.TreeTask

class CheckArea(val area: Area, failure: TreeTask, success: TreeTask): Checker(area.contains(Players.getLocal()), failure, success) {}