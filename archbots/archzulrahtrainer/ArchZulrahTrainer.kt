package archbots.archzulrahtrainer

import archapi.tasks.animation.DebugAnimation
import archapi.tasks.location.ValidateLocation
import archapi.tasks.skills.magic.*
import archapi.treebot.InlineLeafTask
import archapi.treebot.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import com.runemate.game.api.hybrid.local.Skill
import archbots.archzulrahtrainer.ui.controller.ArchZulrahTrainerController
import com.runemate.game.api.hybrid.location.Coordinate
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class ArchZulrahTrainer : TreeBot(), EmbeddableUI, SkillListener {
    //TODO: Implement in settings
    val target = "Grizzly bear"
    val targetLocation = Coordinate(3226, 3500, 0)
    val alchItem = "Rune arrow"
    val teleport = Magic.CAMELOT_TELEPORT


    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(ArchZulrahTrainerController(platform))
        }.let {
            SimpleObjectProperty(it.load(javaClass.classLoader.getResourceAsStream("archbots/archzulrahtrainer/ui/fxml/main.fxml")) as Node)
        }
    }

    init {
        setEmbeddableUI(this)
        taskDebugger = true
        setTask()
    }

    override fun onStart(vararg arguments: String?) {
        setLoopDelay(300, 350)
        eventDispatcher.addListener(this)
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
            in 66..72 -> rootTask =
                    ValidateLocation(targetLocation,
                            AlternateTask(
                                    CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
                                    CastSpellOnNPC(Magic.ENFEEBLE, target)))
            in 73..79 ->
                ValidateLocation(targetLocation,
                        AlternateTask(
                                CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
                                CastSpellOnNPC(Magic.VULNERABILITY, target)))
            in 80..85 ->
                ValidateLocation(targetLocation,
                        AlternateTask(
                                CastSpellOnItem(Magic.HIGH_LEVEL_ALCHEMY, alchItem),
                                CastSpellOnNPC(Magic.STUN, target)))
        }
    }


    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) {}

    override fun onLevelUp(event: SkillEvent?) {
        if (event != null) {
            setTask()
        }
    }

}