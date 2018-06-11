package arch.api.tasks.skills.magic

import arch.api.tasks.animation.AnimationValidator
import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class TeleAlch(val item: String, val teleport: Magic) : BranchTask() {
    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask =
            AnimationValidator(714,
                    AnimationValidator(713,
                            AnimationValidator(-1,
                                    InlineLeafTask {},
                                    CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, item)),
                            InlineLeafTask { teleport.activate() }),
                    SpellSelectedValidator(Magic.HIGH_LEVEL_ALCHEMY, InlineLeafTask {}))

    override fun validate(): Boolean = true
}