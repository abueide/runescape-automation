package archbots.archmage.treebot.branches

import archapi.treebot.framework.BranchTask
import archapi.treebot.framework.InlineLeafTask
import archapi.treebot.framework.TreeTask
import archbots.archmage.treebot.leaves.CastSpellOnTarget
import archbots.archmage.treebot.leaves.Idle
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class SpellSelectedValidator(val magic: Magic): BranchTask(){
    override fun validate(): Boolean = magic.isSelected

    override fun failureTask(): TreeTask = InlineLeafTask({
        val selected = Magic.getSelected()
        if(selected != null)
            selected.deactivate()
        magic.activate()
    })

    override fun successTask(): TreeTask = AnimationValidator(-1, Idle(), CastSpellOnTarget("Grizzly bear"))

}