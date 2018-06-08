package archbots.archmage.treebot.leaves

import archapi.treebot.framework.LeafTask
import com.runemate.game.api.hybrid.region.Npcs

class CastSpellOnTarget(val target: String): LeafTask() {
    override fun execute() {
        Npcs.newQuery().names(target).results().nearest().click()
    }
}