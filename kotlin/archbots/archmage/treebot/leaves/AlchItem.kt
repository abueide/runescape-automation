package archbots.archmage.treebot.leaves

import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory
import com.runemate.game.api.script.Execution
import archapi.treebot.framework.LeafTask

class AlchItem : LeafTask() {
    override fun execute() {
        Inventory.newQuery().names("Rune arrow").results().first().click()
        Execution.delayUntil({ InterfaceWindows.getMagic().isOpen }, 800, 1000)
    }
}
