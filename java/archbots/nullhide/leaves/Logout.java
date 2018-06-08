package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.RuneScape;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class Logout extends LeafTask {
    @Override
    public void execute() {
        RuneScape.logout();
        Environment.getBot().stop("Out of supplies");
    }
}
