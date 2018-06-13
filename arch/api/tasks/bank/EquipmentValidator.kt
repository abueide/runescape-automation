package arch.api.tasks.bank

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.hybrid.entities.Item
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment


class EquipmentValidator(val equipment: List<Item>, val success: TreeTask): BranchTask() {
    override fun failureTask(): TreeTask {
        return UnitLeaf()
    }

    override fun successTask(): TreeTask {
        return UnitLeaf()
    }

    override fun validate(): Boolean = equipment.filter { Equipment.contains(it.id) }.isEmpty()

}