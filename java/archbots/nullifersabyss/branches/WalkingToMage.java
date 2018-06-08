package archbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import archbots.nullifersabyss.leaves.WalkToMage;


/**
 * NOTES:
 */
public class WalkingToMage extends BranchTask {

    private WalkToMage walktomage = new WalkToMage();
    private IsObstacleNear isobstaclenear = new IsObstacleNear();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return isobstaclenear;
    }

    @Override
    public TreeTask successTask() {
        return walktomage;
    }
}
