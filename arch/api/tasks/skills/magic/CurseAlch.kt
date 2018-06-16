package arch.api.tasks.skills.magic

import arch.api.tasks.animation.AnimationValidator
import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CurseAlch(val item: String, val target: String, val curse: Magic) : BranchTask() {
    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask {
        val frame = Players.getLocal().animationFrame
        if (frame >= 1 && frame <= 12 && Players.getLocal().animationId != 713)
            return SpellSelectedValidator(Magic.HIGH_LEVEL_ALCHEMY, InlineLeafTask {})
        else
            return AnimationValidator(713,
                    AnimationValidator(-1,
                            InlineLeafTask {},
                            CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, item)),
                    CastSpellOnNPC(curse, target))
    }

    override fun validate(): Boolean = true
}