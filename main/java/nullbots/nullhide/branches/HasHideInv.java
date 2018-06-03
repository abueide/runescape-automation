package nullbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullhide.leaves.LoadPreset;
import nullbots.nullhide.leaves.TanHide;
import nullbots.nullhide.util.PrefWrapper;

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