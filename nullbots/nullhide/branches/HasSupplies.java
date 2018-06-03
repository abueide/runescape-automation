package nullbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.rs3.local.hud.interfaces.MoneyPouch;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import nullbots.nullhide.leaves.Logout;
import nullbots.nullhide.util.Globals;
import nullbots.nullhide.util.PrefWrapper;

public class HasSupplies extends BranchTask {

    private LeafTask withdrawTask;
    private Logout logout = new Logout();

    public HasSupplies(LeafTask withdrawTask) {
        this.withdrawTask = withdrawTask;
    }

    @Override
    public TreeTask successTask() {
        return withdrawTask;
    }

    @Override
    public TreeTask failureTask() {
        return logout;
    }

    @Override
    public boolean validate() {
        return Bank.contains(PrefWrapper.getHide()) && MoneyPouch.getContents() >= 560 && (Bank.contains(Globals.portableCrafter) || !GameObjects.newQuery().names(Globals.portableCrafter).results().isEmpty());
    }
}
