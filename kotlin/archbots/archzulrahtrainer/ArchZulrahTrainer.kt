package archbots.archzulrahtrainer

import archapi.tasks.location.ValidateLocation
import archapi.treebot.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import com.runemate.game.api.hybrid.local.Skill
import archapi.tasks.skills.magic.CastSpellOnNPC
import archapi.tasks.skills.magic.CastSuperHeat
import archbots.archzulrahtrainer.ui.controller.ArchZulrahTrainerController
import com.runemate.game.api.hybrid.RuneScape
import com.runemate.game.api.hybrid.location.Coordinate
import com.runemate.game.api.osrs.local.hud.interfaces.Magic
import com.runemate.game.api.script.Execution

class ArchZulrahTrainer : TreeBot(), EmbeddableUI, SkillListener{
    //TODO: Implement in settings
    val target = "Grizzly bear"
    val targetLocation = Coordinate(3226, 3500, 0)


    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(ArchZulrahTrainerController(platform))
        }.let {
            SimpleObjectProperty(it.load(javaClass.classLoader.getResourceAsStream("archbots/archzulrahtrainer/ui/fxml/main.fxml")) as Node)
        }
    }
    init{
        setEmbeddableUI(this)
        taskDebugger = true
        setTask()
    }


    fun setTask(){
        when(Skill.MAGIC.baseLevel){
            in 1..2 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.WIND_STRIKE, target))
            in 3..10 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.CONFUSE, target))
            in 11..18 -> rootTask = ValidateLocation(targetLocation, CastSpellOnNPC(Magic.WEAKEN, target))
            in 19..42 -> rootTask =  ValidateLocation(targetLocation, CastSpellOnNPC(Magic.CURSE, target))
            in 43..54 ->
                if(Skill.SMITHING.baseLevel < 15)
                    rootTask = CastSuperHeat("bronze")
                else
                    rootTask = CastSuperHeat("iron")
            in 55..66 -> {
                //TODO: Refactor into leaf task
                RuneScape.logout()
                Execution.delayUntil({!RuneScape.isLoggedIn()})
                stop("Finished tasks")
            }
        }
    }

    override fun onStart(vararg arguments: String?) {
        setLoopDelay(240, 300)
        eventDispatcher.addListener(this)
    }

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) { }

    override fun onLevelUp(event: SkillEvent?) {
        if(event != null) {
            setTask()
        }
    }

}