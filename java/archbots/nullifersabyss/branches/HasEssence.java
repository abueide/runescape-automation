package archbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
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
