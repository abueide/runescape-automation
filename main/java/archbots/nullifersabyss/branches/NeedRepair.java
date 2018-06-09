package archbots.nullifersabyss.branches;

import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;
import archbots.nullifersabyss.leaves.RepairPouch;


/**
 * NOTES:
 */
public class NeedRepair extends BranchTask {

    private RepairPouch repairpouch = new RepairPouch();
    private AltarPortalNear altarportalnear = new AltarPortalNear();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return altarportalnear;
    }

    @Override
    public TreeTask successTask() {
        return repairpouch;
    }
}
