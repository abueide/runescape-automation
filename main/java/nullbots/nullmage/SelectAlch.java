package nullbots.nullmage;

import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class SelectAlch extends LeafTask {

    @Override
    public void execute() {
        Magic.HIGH_LEVEL_ALCHEMY.activate();
        NullMage.lastSpell = true;
    }
}
