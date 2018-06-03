package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.GloryTeleport;
import nullbots.nullifersabyss.leaves.WalkToBank;


/**
 * NOTES:
 */
public class HasGlory extends BranchTask {

    private GloryTeleport gloryteleport = new GloryTeleport();
    private WalkToBank walktobank = new WalkToBank();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return walktobank;
    }

    @Override
    public TreeTask successTask() {
        return gloryteleport;
    }
}
