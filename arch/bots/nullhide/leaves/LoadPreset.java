package arch.bots.nullhide.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import arch.api.treebot.LeafTask;
import arch.bots.nullhide.util.Globals;

public class LoadPreset extends LeafTask {
    int preset = 1;

    public LoadPreset(int preset) {
        this.preset = preset;
    }

    @Override
    public void execute() {
        Globals.hidestanned += 28;
        Bank.loadPreset(preset);
    }
}
