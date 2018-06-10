package archapi.tasks.skills.magic

import archapi.treebot.BranchTask
import archapi.treebot.TreeTask


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