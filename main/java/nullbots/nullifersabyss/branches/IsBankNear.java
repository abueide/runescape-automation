package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.BankItems;


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
