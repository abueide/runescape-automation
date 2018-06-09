package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.CraftEssence;


/**
 * NOTES:
 */
public class HasEssence extends BranchTask {

    private CraftEssence craftessence = new CraftEssence();
    private PouchesEmpty pouchesempty = new PouchesEmpty();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return pouchesempty;
    }

    @Override
    public TreeTask successTask() {
        return craftessence;
    }
}
