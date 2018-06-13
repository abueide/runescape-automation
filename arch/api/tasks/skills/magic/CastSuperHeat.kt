package arch.api.tasks.skills.magic

import arch.api.tasks.bank.InventoryValidator
import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask
import arch.api.treebot.UnitLeaf
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class CastSuperHeat(val bar: String) : BranchTask() {
    val bronzeComponents = setOf(arch.api.ItemOrder("Tin ore", withdrawQuantity = 13), arch.api.ItemOrder("Copper ore", withdrawQuantity = 13), arch.api.ItemOrder("Nature rune", true))
    val ironComponents = setOf(arch.api.ItemOrder("Iron ore", withdrawQuantity =  27), arch.api.ItemOrder("Nature rune", true))

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