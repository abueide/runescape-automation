package arch.api.tasks.general

import arch.api.treebot.LeafTask
import com.runemate.game.api.hybrid.Environment
import com.runemate.game.api.hybrid.RuneScape
import com.runemate.game.api.script.Execution

class Logout: LeafTask(){
    override fun execute() {
        RuneScape.logout()
        Execution.delayUntil({!RuneScape.isLoggedIn()})
        Environment.getBot().stop("Finished tasks")
    }
}