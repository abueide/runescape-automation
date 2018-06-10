package archapi.tasks.skills.magic

import archapi.tasks.animation.AnimationValidator
import archapi.treebot.BranchTask
import archapi.treebot.InlineLeafTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class TeleAlch(val item: String, val teleport: Magic) : BranchTask() {
    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask =
            AnimationValidator(714,
                    AnimationValidator(713,
                            AnimationValidator(-1,
                                    InlineLeafTask{},
                                    CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, item)),
                            InlineLeafTask{teleport.activate()}),
                    SpellSelectedValidator(Magic.HIGH_LEVEL_ALCHEMY, InlineLeafTask{}))

    override fun validate(): Boolean = true
}