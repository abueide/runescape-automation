package nullbots.nullmage;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class ChooseSpell extends BranchTask {

    private SelectAlch selectAlch = new SelectAlch();
    private SelectCurse selectCurse = new SelectCurse();

    @Override
    public TreeTask successTask() {
        return selectCurse;
    }

    @Override
    public TreeTask failureTask() {
        return selectAlch;
    }

    @Override
    public boolean validate() {
        return NullMage.lastSpell;
    }
}
