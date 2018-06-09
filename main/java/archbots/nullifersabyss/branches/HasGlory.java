package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.GloryTeleport;
import archbots.nullifersabyss.leaves.WalkToBank;


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
