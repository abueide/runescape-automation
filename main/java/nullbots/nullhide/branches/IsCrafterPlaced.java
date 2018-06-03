package nullbots.nullhide.branches;

import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullhide.util.Globals;

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
