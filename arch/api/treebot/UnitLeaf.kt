package arch.api.treebot

//Instead of making null tasks, use UnitLeaf and pass in the parent object (via this keyword) for logging purposes.
class UnitLeaf(val parent: Any) : LeafTask() {
    constructor() : this(UnknownParent())

    override fun execute() {
        logger.severe("Unit leaf triggered by " + parent.javaClass.name)
    }
}
