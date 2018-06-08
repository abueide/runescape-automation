package archbots.nullhide.branches;

import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import archapi.treebot.tasks.location.WalkTo;
import archbots.nullhide.util.PrefWrapper;

/**
 * NOTES:
 * Checks if the player is in the correct area
 */
public class IsInArea extends BranchTask {

    private IsCrafterPlaced iscrafterplaced = new IsCrafterPlaced();

    @Override
    public boolean validate() {
        return PrefWrapper.getArea().contains(Players.getLocal().getPosition());
    }

    @Override
    public TreeTask failureTask() {
        return new WalkTo(PrefWrapper.getArea());
    }

    @Override
    public TreeTask successTask() {
        return iscrafterplaced;
    }
}