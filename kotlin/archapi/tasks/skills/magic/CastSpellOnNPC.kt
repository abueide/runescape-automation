package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf
import archapi.tasks.animation.AnimationValidator
import archapi.tasks.animation.Idle
import archapi.tasks.general.ClickNPC
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSpellOnNPC(val magic: Magic, val target: String) : BranchTask() {
    val success =
            AnimationValidator(-1, //Task specific arguments followed by failure and success task
                    Idle(),
                    SpellSelectedValidator(magic,
                            ClickNPC(target)))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask = success

}