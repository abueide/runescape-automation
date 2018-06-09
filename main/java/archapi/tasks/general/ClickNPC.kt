package archapi.tasks.general

import archapi.treebot.LeafTask
import com.runemate.game.api.hybrid.region.Npcs

class ClickNPC(val npc: String): LeafTask() {
    override fun execute() {
        val results = Npcs.newQuery().names(npc).results()
        if(!results.isEmpty())
            results.nearest().click()
    }
}