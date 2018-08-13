# Runescape Automation

Runemate is an api that lets you execute actions and read game state from the popular mmorpg Runescape. This repository
contains kotlin code that uses a custom binary tree framework for decision making. It also contains an embedded GUI 
made using JavaFX, some bots using the framework, and an item ordering system for resupplying and banking.

## Code

This project uses a binary tree framework to represent the decision making of the automation software. Tasks are
are represented by a LeafTask, while decision making is represented by a BranchTask. TreeTask is a superclass of
BranchTask and LeafTask that contains a recursive function `findleaf` that traverses the tree and finds the leaf task to
be executed on that loop.

There is also the start of a Type Safe Builder (kotlin's version of a Domain Specific Language) to represent the
decision trees in code with an easy to read format. Without it constructing decision trees is very unreadable and hard 
to debug.

Some code to look at:

`arch/api/treebot/TreeBot.kt` contains the meat of the binary tree framework.

`arch/api/treebot/TreeTask.kt` superclass of BranchTask and TreeTask

`arch/bots/archzulrahtrainer/ui/controller/ArchZulrahTrainerController.kt` contains some pretty wicked code to track and
 display experience by using an Accordion and dynamically adding panes. It is currently commented out due to multi-threading bug.
 
 `arch/bots/archzulrahtrainer/ArchZulrahTrainer.kt` is the main TreeBot instance for my more complex bot. It switches the
 root Task depending on your current level in game.


