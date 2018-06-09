package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.MageTeleport;


/**
 * NOTES:
 */
public class IsMageNear extends BranchTask {

    private MageTeleport mageteleport = new MageTeleport();
    private WalkingToMage walkingtomage = new WalkingToMage();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return walkingtomage;
    }

    @Override
    public TreeTask successTask() {
        return mageteleport;
    }
}
