package archbots.nullhide.branches;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.rs3.local.hud.interfaces.MoneyPouch;
import archapi.treebot.BranchTask;
import archapi.treebot.LeafTask;
import archapi.treebot.TreeTask;
import archbots.nullhide.leaves.Logout;
import archbots.nullhide.util.Globals;
import archbots.nullhide.util.PrefWrapper;

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
