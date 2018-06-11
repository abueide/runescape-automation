package arch.api.treebot

class InlineLeafTask(val execute: () -> Unit) : LeafTask() {
    override fun execute() = execute.invoke()
}