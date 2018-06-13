package arch.api.tasks.bank

import arch.api.ItemOrder
import arch.api.tasks.general.Logout
import arch.api.treebot.BranchTask
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory

class InventoryValidator(val items: Set<ItemOrder>, val success: TreeTask) : BranchTask() {
    //Items needed for the bot to continue functioning
    val criticalItems = items.filter { item -> Inventory.getQuantity(item.name) < item.minimumQuantity }
    //Items to be restocked at the bank, but shouldn't trigger a trip to the bank
    val restockItems = items.filter { item -> Inventory.getQuantity(item.name) < item.withdrawQuantity }

    //If the bank is open make sure we've restocked all items fully. If its not, only go to the bank if we are out of a
    // critical supply.
    override fun validate(): Boolean = if (Bank.isOpen()) restockItems.filter { item -> Bank.contains(item.name) }.isEmpty() else criticalItems.isEmpty()

    override fun failureTask(): TreeTask {
        //If the bank is out of a critical supply, logout. If its not return a leaf task that withdraws the next item
        //in the restock list if the bank has it
        if (Bank.isOpen()) {
            val bankOutOfItems = criticalItems.filter { item -> !Bank.contains(item.name) }
            if (!bankOutOfItems.isEmpty())
                return Logout("Missing critical items: " + bankOutOfItems.toString())
            else {
                val nextItem = restockItems.filter { item -> Bank.contains(item.name) }.first()
                return InlineLeafTask {
                    Bank.withdraw(nextItem.name, nextItem.withdrawQuantity)
                }
            }
        }
        //If the bank isn't open, walk to the nearest bank and open it.
        else
            return BankOpenValidator(true, InlineLeafTask { })
    }

    override fun successTask(): TreeTask = success
}