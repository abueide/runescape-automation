package archapi.treebot.tasks.location

import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.region.Players
import archapi.treebot.tasks.general.Validator
import archapi.treebot.framework.TreeTask

class CheckArea(val area: Area, failure: TreeTask, success: TreeTask): Validator(area.contains(Players.getLocal()), failure, success) {}