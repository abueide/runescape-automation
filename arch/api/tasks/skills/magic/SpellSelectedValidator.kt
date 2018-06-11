package arch.api.tasks.skills.magic

import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

//For selecting spells that don't open a new interface
class SpellSelectedValidator(val magic: Magic, val success: TreeTask): BranchTask(){
    override fun validate(): Boolean = magic.isSelected

    override fun failureTask(): TreeTask = InlineLeafTask({
        val selected = Magic.getSelected()
        if (selected != null)
            selected.deactivate()
        magic.activate()
    })

    override fun successTask(): TreeTask = success

}