package archbots.nullhide.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import com.runemate.game.api.hybrid.region.GameObjects;
import archbots.nullhide.util.Globals;

/**
 * NOTES:
 * Walk to the correct area
 */
public class IsCrafterPlaced extends BranchTask {

    private HasHideInv hashideinv = new HasHideInv();
    private HasCrafterInv hascrafterinv = new HasCrafterInv();

    @Override
    public boolean validate() {
        return !GameObjects.newQuery().names(Globals.portableCrafter).results().isEmpty();
    }

    @Override
    public TreeTask failureTask() {
        return hascrafterinv;
    }

    @Override
    public TreeTask successTask() {
        return hashideinv;
    }
}
