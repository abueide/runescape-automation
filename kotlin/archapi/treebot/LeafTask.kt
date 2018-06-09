package archapi.treebot

abstract class LeafTask: TreeTask(){
    abstract fun execute(): Unit
}