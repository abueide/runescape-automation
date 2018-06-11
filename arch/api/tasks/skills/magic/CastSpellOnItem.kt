package arch.api.tasks.skills.magic

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import arch.api.tasks.bank.BankValidator
import arch.api.tasks.general.ClickItem
import arch.api.treebot.InlineLeafTask
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows
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