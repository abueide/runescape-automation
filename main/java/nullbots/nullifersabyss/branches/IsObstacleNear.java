package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.ClearObstacle;


/**
 * NOTES:
 */
public class IsObstacleNear extends BranchTask {

    private ClearObstacle clearobstacle = new ClearObstacle();
    private RepairMageNear repairmagenear = new RepairMageNear();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return repairmagenear;
    }

    @Override
    public TreeTask successTask() {
        return clearobstacle;
    }
}
