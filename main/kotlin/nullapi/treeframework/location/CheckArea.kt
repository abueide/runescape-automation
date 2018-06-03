package nullapi.treeframework.location

import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.script.framework.tree.TreeTask
import nullapi.treeframework.Validator

class CheckArea(val area: Area, failure: TreeTask, success: TreeTask): Validator(area.contains(Players.getLocal()), failure, success) {}