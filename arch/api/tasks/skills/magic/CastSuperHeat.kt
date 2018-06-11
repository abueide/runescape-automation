package arch.api.tasks.skills.magic

import arch.api.resupply.ItemOrder
import arch.api.tasks.bank.InventoryValidator
import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSuperHeat(val bar: String) : BranchTask() {
    val bronzeComponents = listOf(ItemOrder("Tin ore", 13), ItemOrder("Copper ore", 13), ItemOrder("Nature rune", 1))
    val ironComponents = listOf(ItemOrder("Iron ore", 27), ItemOrder("Nature rune", 1))

    override fun validate(): Boolean = true

    override fun failureTask(): TreeTask = UnitLeaf(this)

    override fun successTask(): TreeTask {
        when (bar.toLowerCase()) {
            "bronze" ->
                return InventoryValidator(bronzeComponents,
                        CastSpellOnItem(Magic.SUPERHEAT_ITEM, "Tin ore")
                )
            "iron" ->
                return InventoryValidator(ironComponents,
                        CastSpellOnItem(Magic.SUPERHEAT_ITEM, "Iron ore")
                )
            else -> throw UnsupportedOperationException("Bar type not supported")
        }
    }
}