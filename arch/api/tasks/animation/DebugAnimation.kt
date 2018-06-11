package arch.api.tasks.animation

import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.region.Players

class DebugAnimation: LeafTask() {
    override fun execute() {
        logger.debug("Animation: " + Players.getLocal().animationId + ", Frame: " + Players.getLocal().animationFrame)
    }
}