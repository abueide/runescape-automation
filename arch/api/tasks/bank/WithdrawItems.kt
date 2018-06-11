package arch.api.tasks.bank

import arch.api.resupply.ItemOrder
import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory
import com.runemate.game.api.script.Execution

class WithdrawItems(val items: List<ItemOrder>): LeafTask(){
    override fun execute() {
        Bank.depositAllExcept(*items.map { it.name }.toTypedArray())
        val nextItem = items.filter { item -> Inventory.getQuantity(item.name) < item.restockQuantity}.first()
        Bank.withdraw(nextItem.name, nextItem.restockQuantity - Inventory.getQuantity(nextItem.name))
        Execution.delayUntil({Inventory.contains(nextItem.name)}, 500)
    }
}