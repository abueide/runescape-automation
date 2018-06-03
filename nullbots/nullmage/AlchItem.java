package nullbots.nullmage;

import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class AlchItem extends LeafTask {
    @Override
    public void execute() {
        Inventory.newQuery().names("Rune arrow").results().first().click();
        Execution.delayUntil(InterfaceWindows.getMagic()::isOpen, 800, 1000);
    }
}
