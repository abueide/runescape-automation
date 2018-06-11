package arch.bots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import arch.api.treebot.BranchTask;
import arch.api.treebot.TreeTask;
import arch.bots.nullhide.leaves.PlaceCrafter;
import arch.bots.nullhide.leaves.Withdraw;
import arch.bots.nullhide.util.Globals;

/**
 * NOTES:
 * Checks if the portable crafter is in the player's inventory.
 */
public class HasCrafterInv extends BranchTask {

    private PlaceCrafter placecrafter = new PlaceCrafter();
    private IsBankOpenLeaf isBankOpenLeaf = new IsBankOpenLeaf(new Withdraw(Globals.portableCrafter, 1));

    @Override
    public boolean validate() {
        return Inventory.contains(Globals.portableCrafter);
    }

    @Override
    public TreeTask failureTask() {
        return isBankOpenLeaf;
    }

    @Override
    public TreeTask successTask() {
        return placecrafter;
    }
}
