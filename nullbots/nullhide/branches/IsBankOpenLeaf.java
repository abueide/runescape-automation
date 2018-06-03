package nullbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullhide.leaves.OpenBank;

public class IsBankOpenLeaf extends BranchTask {
    private OpenBank openBank = new OpenBank();
    private HasSupplies hasSupplies;

    public IsBankOpenLeaf(LeafTask withdrawTask) {
        hasSupplies = new HasSupplies(withdrawTask);
    }


    @Override
    public TreeTask successTask() {
        return hasSupplies;
    }

    @Override
    public TreeTask failureTask() {
        return openBank;
    }

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }
}
