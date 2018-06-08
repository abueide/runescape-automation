package archapi.treebot.framework

import com.runemate.game.api.script.framework.LoopingBot

abstract class TreeBot() : LoopingBot() {

    var rootTask: TreeTask = UnitLeaf()

    override fun onLoop() {
        logger.debug(rootTask.findLeaf().javaClass.name)
        rootTask.findLeaf().execute()
    }
}
