package archbots.nullifersabyss.branches;

import com.runemate.game.api.hybrid.region.Banks;
import archapi.treebot.BranchTask;
import archapi.treebot.TreeTask;


/**
 * NOTES:
 */
public class ShouldBank extends BranchTask {

    private IsBankNear isbanknear = new IsBankNear();
    private IsMageNear ismagenear = new IsMageNear();

    @Override
    public boolean validate() {
        if (!Banks.newQuery().results().isEmpty()) {

        } else {

        }
        return true;
    }

    @Override
    public TreeTask failureTask() {
        return ismagenear;
    }

    @Override
    public TreeTask successTask() {
        return isbanknear;
    }
}
