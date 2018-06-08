package archbots.nullmage;

import archbots.kotlintemplate.treebot.leaves.Idle;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsIdle extends BranchTask {

    private IsAlchSelected isAlchSelected = new IsAlchSelected();
    private Idle idle = new Idle();

    @Override
    public TreeTask successTask() {
        return isAlchSelected;
    }

    @Override
    public TreeTask failureTask() {
        return idle;
    }

    @Override
    public boolean validate() {
        return Players.getLocal().getAnimationId() == -1;
    }
}
