package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.RuneScape;
import archapi.treebot.LeafTask;

public class Logout extends LeafTask {
    @Override
    public void execute() {
        RuneScape.logout();
        Environment.getBot().stop("Out of supplies");
    }
}
