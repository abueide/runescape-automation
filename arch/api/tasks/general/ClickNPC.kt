package arch.api.tasks.general

import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.region.Npcs
import com.runemate.game.api.hybrid.region.Players
import com.runemate.game.api.script.Execution

class ClickNPC(val npc: String) : LeafTask() {
    override fun execute() {
        val results = Npcs.newQuery().names(npc).results()
        if (!results.isEmpty()) {
            results.nearest().click()
            Execution.delay(700,900)
        }
    }
}