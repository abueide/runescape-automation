package archbots.nullmage;

import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class SelectCurse extends LeafTask {
    @Override
    public void execute() {
        Magic.STUN.activate();
        NullMage.lastSpell = false;
    }
}
