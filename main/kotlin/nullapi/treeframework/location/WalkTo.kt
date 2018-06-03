package nullapi.treeframework.location

import com.runemate.game.api.hybrid.entities.details.Locatable
import com.runemate.game.api.hybrid.location.navigation.Traversal
import com.runemate.game.api.script.framework.tree.LeafTask

class WalkTo(val locatable: Locatable): LeafTask() {
    val webpath = Traversal.getDefaultWeb().pathBuilder.buildTo(locatable);

    override fun execute() {
        webpath.step();
    }
}