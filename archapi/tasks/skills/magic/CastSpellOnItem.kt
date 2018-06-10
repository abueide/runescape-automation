package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf
import archapi.tasks.bank.BankValidator
import archapi.tasks.general.ClickItem
import archapi.treebot.InlineLeafTask
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import com.runemate.game.api.script.Execution

class CastSpellOnItem(val magic: Magic, val item: String) : BranchTask() {
    val success = BankValidator(false, SpellSelectedValidator(magic,
            InlineLeafTask {
                Execution.delayUntil({ InterfaceWindows.getInventory().isOpen }, 1000, 1200)
                ClickItem(item).execute()
                Execution.delayUntil({ InterfaceWindows.getMagic().isOpen }, 1000, 1200)
            }))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask = success

}