package arch.bots.nullhide.branches;

import com.runemate.game.api.hybrid.region.Players;
import arch.api.treebot.BranchTask;
import arch.api.treebot.TreeTask;
import arch.api.tasks.location.WalkTo;
import arch.bots.nullhide.util.PrefWrapper;

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
