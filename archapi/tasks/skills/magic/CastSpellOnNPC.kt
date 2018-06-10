package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf
import archapi.tasks.general.ClickNPC
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSpellOnNPC(val magic: Magic, val target: String) : BranchTask() {
    val success = SpellSelectedValidator(magic, ClickNPC(target))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask = success

}