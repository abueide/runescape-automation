package nullbots.kotlintemplate

import com.runemate.game.api.script.framework.tree.BranchTask
import com.runemate.game.api.script.framework.tree.TreeTask
import nullbots.kotlintemplate.treebot.leaves.Idle

class TemplateRoot: BranchTask(){
    val idle = Idle()
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask? = null
    override fun successTask(): TreeTask  = idle
}