package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;
import archbots.nullhide.util.Globals;

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
