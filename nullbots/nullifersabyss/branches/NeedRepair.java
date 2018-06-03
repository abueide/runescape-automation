package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.RepairPouch;


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
