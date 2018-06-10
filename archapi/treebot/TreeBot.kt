package archapi.treebot

import com.runemate.game.api.script.framework.LoopingBot

abstract class TreeBot() : LoopingBot() {

    var rootTask: TreeTask = UnitLeaf(this)

    var taskDebugger = false

    override fun onLoop() {
        if (taskDebugger)
            logger.debug(rootTask.findLeaf().javaClass.name)
        rootTask.findLeaf().execute()
    }

}
