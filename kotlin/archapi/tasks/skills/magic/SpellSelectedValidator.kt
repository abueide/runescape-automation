package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.InlineLeafTask
import archapi.treebot.TreeTask
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

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