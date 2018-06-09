package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.input.Keyboard;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.ChatDialog;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.hybrid.queries.results.SpriteItemQueryResults;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import archapi.treebot.LeafTask;
import archbots.nullhide.util.Globals;
import archbots.nullhide.util.PrefWrapper;

/**
 * NOTES:
 * Walk to the correct area
 */
public class PlaceCrafter extends LeafTask {

    @Override
    public void execute() {
        if (Bank.isOpen())
            Bank.close();
        if (!Players.getLocal().getPosition().equals(PrefWrapper.getCrafterLocation())) {
            ViewportPath.convert(BresenhamPath.buildTo(PrefWrapper.getCrafterLocation())).step();
            Execution.delayUntil(() -> Players.getLocal().getPosition().equals(PrefWrapper.getCrafterLocation()), 2000);
        }

        SpriteItemQueryResults portableCrafters = Inventory.getItems(Globals.portableCrafter);
        if (!portableCrafters.isEmpty() && !(ChatDialog.getOptions().size() > 0)) {
            portableCrafters.first().interact("Deploy");
            Execution.delayUntil(() -> ChatDialog.getOptions().size() > 0, 1000);
        }
        if (ChatDialog.getOptions().size() > 0) {
            Keyboard.typeKey('1');
        }

        System.out.println("Hides tanned: " + Globals.hidestanned);
        Globals.hidestanned = 0;
    }

}
