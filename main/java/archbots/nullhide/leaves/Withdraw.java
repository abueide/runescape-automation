package archbots.nullhide.leaves;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import archapi.treebot.LeafTask;

public class Withdraw extends LeafTask {
    String item;
    int quantity;

    public Withdraw(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        if (Inventory.isFull()) {
            //only for making sure room for portable crafter
            Bank.deposit(Inventory.getItemIn(1), 1);
        }
        Bank.withdraw(item, quantity);
    }
}
