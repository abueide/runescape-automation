package arch.bots.nullhide.leaves;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.navigation.Landmark;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import arch.api.treebot.LeafTask;

/**
 * NOTES:
 * Walk to the correct area
 */
public class WalkToArea extends LeafTask {
    private WebPath webPath;

    public WalkToArea(Landmark landmark) {
        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(landmark);
    }

    public WalkToArea(Area area) {
        webPath = Traversal.getDefaultWeb().getPathBuilder().buildTo(area);
    }


    @Override
    public void execute() {
        if (webPath != null)
            webPath.step();
    }
}
