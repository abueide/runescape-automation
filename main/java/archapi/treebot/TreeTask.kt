package archapi.treebot

import com.runemate.game.api.hybrid.Environment


abstract class TreeTask {

    val logger = Environment.getLogger()

    fun findLeaf(): LeafTask = when(this){
        is LeafTask -> this
        is BranchTask -> this.nextTask().findLeaf()
        else -> throw UnsupportedOperationException("Unsupported TreeTask type: " + this.javaClass.name)
    }
}