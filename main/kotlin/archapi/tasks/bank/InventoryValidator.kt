package archapi.tasks.bank

import archapi.resupply.ItemOrder
import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory

class InventoryValidator(val items: List<ItemOrder>, val success: TreeTask): BranchTask() {
    val itemsNeeded = items.filter {  item -> !Inventory.contains(item.name)  }

    override fun validate(): Boolean {
        if(itemsNeeded.isEmpty())
            return true
        else
            return false
    }


    override fun failureTask(): TreeTask = BankValidator(true, WithdrawItems(items))

    override fun successTask(): TreeTask = success
}