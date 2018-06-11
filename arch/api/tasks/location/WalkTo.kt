package arch.api.tasks.location

import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.entities.details.Locatable
import com.runemate.game.api.hybrid.location.navigation.Traversal

class WalkTo(locatable: Locatable): LeafTask() {
    val webpath = Traversal.getDefaultWeb().pathBuilder.buildTo(locatable);

    override fun execute() {
        webpath.step();
    }
}