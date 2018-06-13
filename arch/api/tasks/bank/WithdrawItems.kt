package arch.api.tasks.bank

import arch.api.ItemOrder
import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory

class WithdrawItems(val items: Set<ItemOrder>) : LeafTask() {
    override fun execute() {
        Bank.depositAllExcept(*items.map { it.name }.toTypedArray())
        val nextItem = items.filter {
            item -> ((Bank.contains(item.name) && item.stacks) || Inventory.getQuantity() < item.withdrawQuantity)
        } .first()
        Bank.withdraw(nextItem.name, nextItem.withdrawQuantity)
    }
}