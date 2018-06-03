package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.InvalidState;


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
