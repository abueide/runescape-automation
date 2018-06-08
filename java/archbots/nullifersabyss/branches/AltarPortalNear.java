package archbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
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
