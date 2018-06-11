package arch.api.treebot

import com.runemate.game.api.hybrid.util.StopWatch
import com.runemate.game.api.script.framework.LoopingBot

abstract class TreeBot() : LoopingBot() {

    val stopWatch = StopWatch()

    var rootTask: TreeTask = UnitLeaf(this)

    var taskDebugger = false

    override fun onLoop() {
        if (taskDebugger)
            logger.debug(rootTask.findLeaf().javaClass.name)
        rootTask.findLeaf().execute()
    }

    override fun onStart(vararg arguments: String?) {
        super.onStart(*arguments)
        stopWatch.start()
    }

    override fun onPause() {
        stopWatch.stop()
    }

    override fun onResume() {
        stopWatch.start()
    }

}
