package arch.bots.archzulrahtrainer

import arch.api.tasks.location.ValidateLocation
import arch.api.tasks.skills.magic.*
import arch.api.treebot.InlineLeafTask
import arch.api.treebot.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import com.runemate.game.api.hybrid.local.Skill
import arch.bots.archzulrahtrainer.ui.controller.ArchZulrahTrainerController
import arch.bots.nullhide.leaves.Logout
import com.runemate.game.api.hybrid.location.Coordinate
import com.runemate.game.api.hybrid.util.Resources
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class ArchZulrahTrainer : TreeBot(), EmbeddableUI, SkillListener {
    val controller = ArchZulrahTrainerController(platform)

    //TODO: Implement in settings
    val target = "Grizzly bear"
    val targetLocation = Coordinate(3226, 3500, 0)
    val alchItem = "Rune arrow"
    val teleport = Magic.CAMELOT_TELEPORT


    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(controller)
        }.let {
            SimpleObjectProperty(it.load(Resources.getAsStream("arch/bots/archzulrahtrainer/ui/fxml/main.fxml")) as Node)
        }
    }

    init {
        setEmbeddableUI(this)
        rootTask = InlineLeafTask {}
//        taskDebugger = true
        setTask()
    }

    override fun onStart(vararg arguments: String?) {
        super.onStart(*arguments)
        setLoopDelay(300, 350)
        eventDispatcher.addListener(this)
        eventDispatcher.addListener(controller)
    }

    override fun onResume() {
        super.onResume()
        setTask()
    }

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onLevelUp(event: SkillEvent?) {
        if (event != null) {
            setTask()
        }
    }

    fun setTask() {
        when (Skill.MAGIC.baseLevel) {
            in 1..2 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.WIND_STRIKE, target))
            in 3..10 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.CONFUSE, target))
            in 11..18 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.WEAKEN, target))
            in 19..42 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.CURSE, target))
            in 43..54 ->
                if (Skill.SMITHING.baseLevel < 15)
                    rootTask = CastSuperHeat("bronze")
                else
                    rootTask = CastSuperHeat("iron")
            in 55..65 -> rootTask = TeleAlch(alchItem, teleport)
            in 66..100 -> rootTask = Logout()
//            in 66..72 -> rootTask =
//                    ValidateLocation(targetLocation,
//                            AlternateTask(
//                                    CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
//                                    CastSpellOnNPC(Magic.ENFEEBLE, target)))
//            in 73..79 ->
//                ValidateLocation(targetLocation,
//                        AlternateTask(
//                                CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
//                                CastSpellOnNPC(Magic.VULNERABILITY, target)))
//            in 80..85 ->
//                ValidateLocation(targetLocation,
//                        AlternateTask(
//                                CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
//                                CastSpellOnNPC(Magic.STUN, target)))
        }
    }
}