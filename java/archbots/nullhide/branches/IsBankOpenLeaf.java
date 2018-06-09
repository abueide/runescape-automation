package archbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import archapi.treebot.BranchTask;
import archapi.treebot.LeafTask;
import archapi.treebot.TreeTask;
import archbots.nullhide.leaves.OpenBank;

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
