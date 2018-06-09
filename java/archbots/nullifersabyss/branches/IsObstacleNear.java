package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.ClearObstacle;


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
