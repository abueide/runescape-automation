package arch.bots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import arch.api.treebot.BranchTask;
import arch.api.treebot.TreeTask;
import arch.bots.nullhide.leaves.LoadPreset;
import arch.bots.nullhide.leaves.TanHide;
import arch.bots.nullhide.util.PrefWrapper;

/**
 * NOTES:
 * Checks if hide is in the inventory
 */
public class HasHideInv extends BranchTask {

    private TanHide tanhide = new TanHide();
    private IsBankOpenLeaf isBankOpenLeaf = new IsBankOpenLeaf(new LoadPreset(1));

    @Override
    public boolean validate() {
        return Inventory.contains(PrefWrapper.getHide());
    }

    @Override
    public TreeTask failureTask() {
        return isBankOpenLeaf;
    }

    @Override
    public TreeTask successTask() {
        return tanhide;
    }
}
