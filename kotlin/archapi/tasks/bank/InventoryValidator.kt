package archapi.tasks.bank

import archapi.resupply.ItemOrder
import archapi.treebot.BranchTask
import archapi.treebot.TreeTask
import archapi.treebot.UnitLeaf

class InventoryValidator(val items: List<ItemOrder>): BranchTask() {
//    var itemsNeeded: List<Items>
    override fun validate(): Boolean = true
//        items.forEach {
//            item -> if (Inventory.newQuery().names(item.name).results().isEmpty())
//        }


    override fun failureTask(): TreeTask = UnitLeaf()

    override fun successTask(): TreeTask = UnitLeaf()
}