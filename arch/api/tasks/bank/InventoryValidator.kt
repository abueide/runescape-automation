package arch.api.tasks.bank

import arch.api.resupply.ItemOrder
import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory

class InventoryValidator(val items: List<ItemOrder>, val success: TreeTask): BranchTask() {
    val itemsNeeded = items.filter {  item -> !Inventory.contains(item.name)  }

    override fun validate(): Boolean = itemsNeeded.isEmpty()

    override fun failureTask(): TreeTask = BankValidator(true, WithdrawItems(items))

    override fun successTask(): TreeTask = success
}