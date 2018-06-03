package nullbots.nullmage;

import com.runemate.game.api.hybrid.region.Npcs;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class CurseBear extends LeafTask {
    @Override
    public void execute() {
        Npcs.newQuery().names("Grizzly bear").results().nearest().click();
    }
}
