package archapi.treebot

abstract class BranchTask: TreeTask() {
    abstract fun failureTask(): TreeTask
    abstract fun successTask(): TreeTask
    abstract fun validate(): Boolean
    fun nextTask(): TreeTask = if (validate()) successTask() else failureTask()
}