package archapi.tasks.general

import archapi.treebot.LeafTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory

class ClickItem(val item: String): LeafTask() {
    override fun execute() {
        val results = Inventory.newQuery().names(item).results()
        if(!results.isEmpty())
            results.first().click()
    }
}