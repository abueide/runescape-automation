package archapi.tasks.bank

import archapi.treebot.BranchTask
import archapi.treebot.InlineLeafTask
import archapi.treebot.TreeTask
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank
import com.runemate.game.api.hybrid.location.navigation.Landmark
import com.runemate.game.api.hybrid.location.navigation.Traversal
import com.runemate.game.api.hybrid.region.Banks

class BankValidator(val bankShouldBeOpen: Boolean,val success: TreeTask): BranchTask(){
    //We only want to return success task if we want the bank to be open and it isopen,
    //or if we want the bank closed and it is closed
    //So we validate Bank.isOpen() == bankShouldBeOpen
    override fun validate(): Boolean = Bank.isOpen() == bankShouldBeOpen

    override fun failureTask(): TreeTask {
        if (bankShouldBeOpen) {
            val openBank = InlineLeafTask { Bank.open() }
            val banks = Banks.getLoaded()

            if (banks.isNotEmpty() && banks.nearest().isVisible)
                return openBank
            else
                //Walk to bank if one is not visible
                return InlineLeafTask { Traversal.getDefaultWeb().pathBuilder.buildTo(Landmark.BANK).step() }

        }else{
            //Close the bank if it is open and we want it closed
            return InlineLeafTask{Bank.close()}
        }
    }
    override fun successTask():TreeTask = success

}