package archbots.nullifersabyss;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.branches.ShouldBank;


/**
 * NOTES:
 * This is the root node.
 * <p>
 * Add children of this branch using the settings to the right.
 */
public class Root extends BranchTask {

    private ShouldBank shouldbank = new ShouldBank();

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public TreeTask successTask() {
        return shouldbank;
    }
}
