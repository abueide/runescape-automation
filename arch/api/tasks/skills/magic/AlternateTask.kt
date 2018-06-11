package arch.api.tasks.skills.magic

import arch.api.treebot.BranchTask
import arch.api.treebot.TreeTask


class AlternateTask(val firstTask: TreeTask, val secondTask: TreeTask): BranchTask() {

    var taskTracker = true

    override fun successTask(): TreeTask{
        taskTracker = !taskTracker
        return firstTask
    }


    override fun failureTask(): TreeTask{
        taskTracker = !taskTracker
        return secondTask
    }

    override fun validate(): Boolean = taskTracker
}