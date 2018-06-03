package nullbots.nullmage;

import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsCurseSelected extends BranchTask {

    private ChooseSpell chooseSpell = new ChooseSpell();
    private CurseBear curseBear = new CurseBear();

    @Override
    public TreeTask successTask() {
        return curseBear;
    }

    @Override
    public TreeTask failureTask() {
        return chooseSpell;
    }

    @Override
    public boolean validate() {
        return Magic.STUN.isSelected();
    }
}
