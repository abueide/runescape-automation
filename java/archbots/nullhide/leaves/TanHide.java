package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.rs3.local.hud.interfaces.MakeXInterface;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;
import archbots.nullhide.util.Globals;

/**
 * NOTES:
 * Walk to the correct area
 */
public class TanHide extends LeafTask {

    @Override
    public void execute() {
        if (Bank.isOpen())
            Bank.close();
        GameObject pCrafter = GameObjects.newQuery().names(Globals.portableCrafter).results().nearest();
        if (pCrafter != null && Players.getLocal().getAnimationId() == -1) {
            pCrafter.interact("Tan Leather");
            Execution.delayUntil(() -> MakeXInterface.isOpen(), 150);
        }
        if (MakeXInterface.isOpen()) {
            Keyboard.typeKey(" ");
        }
    }
}
