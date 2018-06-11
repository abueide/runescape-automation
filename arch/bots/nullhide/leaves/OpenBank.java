package arch.bots.nullhide.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import arch.api.treebot.LeafTask;

public class OpenBank extends LeafTask {

    @Override
    public void execute() {
        Bank.open();
    }
}
