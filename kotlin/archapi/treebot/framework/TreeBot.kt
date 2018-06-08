package archapi.treebot.framework

import com.runemate.game.api.script.framework.LoopingBot

abstract class TreeBot() : LoopingBot() {

    var rootTask: TreeTask = UnitLeaf()

    var taskDebugger = false

    override fun onLoop() {
        if (taskDebugger)
            logger.debug(rootTask.findLeaf().javaClass.name)
        rootTask.findLeaf().execute()
    }

    fun enableTaskDebugger() = {
        taskDebugger = true
    }
}
