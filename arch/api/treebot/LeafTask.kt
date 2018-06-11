package arch.api.treebot

abstract class LeafTask : TreeTask() {
    abstract fun execute(): Unit
}