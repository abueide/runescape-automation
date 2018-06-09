package archbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullhide.leaves.PlaceCrafter;
import archbots.nullhide.leaves.Withdraw;
import archbots.nullhide.util.Globals;

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
