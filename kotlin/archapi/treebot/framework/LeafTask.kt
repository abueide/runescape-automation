package archapi.treebot.framework

abstract class LeafTask: TreeTask(){
    abstract fun execute(): Unit
}