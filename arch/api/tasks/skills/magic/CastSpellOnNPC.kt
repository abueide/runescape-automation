package arch.api.tasks.skills.magic

import arch.api.tasks.animation.AnimationValidator
import arch.api.tasks.general.ClickNPC
import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSpellOnNPC(val magic: Magic, val target: String) : BranchTask() {
    val success = SpellSelectedValidator(magic, AnimationValidator(-1, InlineLeafTask{}, ClickNPC(target)))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask = success

}