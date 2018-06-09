package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.BankItems;


/**
 * NOTES:
 */
public class IsBankNear extends BranchTask {

    private BankItems bank = new BankItems();
    private HasGlory hasglory = new HasGlory();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return hasglory;
    }

    @Override
    public TreeTask successTask() {
        return bank;
    }
}
