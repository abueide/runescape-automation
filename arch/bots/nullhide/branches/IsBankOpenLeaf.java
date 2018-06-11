package arch.bots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import arch.api.treebot.BranchTask;
import arch.api.treebot.LeafTask;
import arch.api.treebot.TreeTask;
import arch.bots.nullhide.leaves.OpenBank;

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
