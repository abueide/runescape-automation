package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.EnterAltar;

/**
 * NOTES:
 */
public class AltarPortalNear extends BranchTask {

    private EnterAltar enteraltar = new EnterAltar();
    private AltarNear altarnear = new AltarNear();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return altarnear;
    }

    @Override
    public TreeTask successTask() {
        return enteraltar;
    }
}
