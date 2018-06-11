package arch.bots.nullhide.branches;

import arch.api.treebot.BranchTask;
import arch.api.treebot.TreeTask;
import arch.bots.nullhide.leaves.OpenBank;

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
