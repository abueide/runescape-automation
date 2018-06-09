package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf
import archapi.tasks.animation.AnimationValidator
import archapi.tasks.animation.Idle
import archapi.tasks.general.ClickItem
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSpellOnItem(val magic: Magic, val item: String) : BranchTask() {
    val success =
            AnimationValidator(-1,
                    Idle(),
                    SpellSelectedValidator(magic,
                            ClickItem(item)))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask = success

}