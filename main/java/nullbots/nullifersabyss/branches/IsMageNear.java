package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.MageTeleport;


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
