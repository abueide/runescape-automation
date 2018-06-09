package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.InvalidState;


/**
 * NOTES:
 */
public class RepairMageNear extends BranchTask {

    private NeedRepair needrepair = new NeedRepair();
    private InvalidState invalidstate = new InvalidState();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return invalidstate;
    }

    @Override
    public TreeTask successTask() {
        return needrepair;
    }
}
