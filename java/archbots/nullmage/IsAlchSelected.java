package archbots.nullmage;

import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsAlchSelected extends BranchTask {

    private AlchItem alchItem = new AlchItem();
    private IsCurseSelected isCurseSelected = new IsCurseSelected();

    @Override
    public TreeTask successTask() {
        return alchItem;
    }

    @Override
    public TreeTask failureTask() {
        return isCurseSelected;
    }

    @Override
    public boolean validate() {
        return Magic.HIGH_LEVEL_ALCHEMY.isSelected();
    }
}
