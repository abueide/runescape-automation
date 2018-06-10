package archbots.kotlintemplate

import com.runemate.game.api.script.framework.tree.BranchTask
import com.runemate.game.api.script.framework.tree.TreeTask
import archbots.kotlintemplate.treebot.leaves.Idle

class TemplateRoot: BranchTask(){
    val idle = Idle()
    override fun validate(): Boolean = true
    override fun failureTask(): TreeTask? = null
    override fun successTask(): TreeTask  = idle
}