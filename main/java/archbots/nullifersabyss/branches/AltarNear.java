package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;


/**
 * NOTES:
 */
public class AltarNear extends BranchTask {

    private HasEssence hasessence = new HasEssence();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return null;
    }

    @Override
    public TreeTask successTask() {
        return hasessence;
    }
}
