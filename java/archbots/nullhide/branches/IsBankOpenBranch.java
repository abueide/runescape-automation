package archbots.nullhide.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import archbots.nullhide.leaves.OpenBank;

public class IsBankOpenBranch extends BranchTask {

    private BranchTask branchTask;
    private OpenBank openBank = new OpenBank();

    public IsBankOpenBranch(BranchTask branchTask) {
        this.branchTask = branchTask;
    }

    @Override
    public TreeTask successTask() {
        return branchTask;
    }

    @Override
    public TreeTask failureTask() {
        return openBank;
    }

    @Override
    public boolean validate() {
        return false;
    }
}
