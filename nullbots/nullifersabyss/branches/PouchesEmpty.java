package nullbots.nullifersabyss.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullifersabyss.leaves.EmptyPouches;
import nullbots.nullifersabyss.leaves.GloryTeleport;


/**
 * NOTES:
 */
public class PouchesEmpty extends BranchTask {

    private GloryTeleport gloryteleport = new GloryTeleport();
    private EmptyPouches emptypouches = new EmptyPouches();

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public TreeTask failureTask() {
        return emptypouches;
    }

    @Override
    public TreeTask successTask() {
        return gloryteleport;
    }
}
