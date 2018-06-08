package archapi.treebot.framework

class InlineLeafTask(val execute: () -> Unit): LeafTask() {
    override fun execute() = execute.invoke()
}