package archbots.archzulrahtrainer

import archapi.treebot.TreeBot
import archapi.tasks.skills.magic.CastSpellOnItem
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import com.runemate.game.api.hybrid.local.Skill
import archapi.tasks.skills.magic.CastSpellOnNPC
import archbots.archzulrahtrainer.ui.controller.ArchZulrahTrainerController
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class ArchZulrahTrainer : TreeBot(), EmbeddableUI, SkillListener{
    //TODO: Implement in settings
    val target = "Grizzly bear"


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
            in 1..2 -> rootTask = CastSpellOnNPC(Magic.WIND_STRIKE, target)
            in 3..10 -> rootTask = CastSpellOnNPC(Magic.CONFUSE, target)
            in 11..18 -> rootTask = CastSpellOnNPC(Magic.WEAKEN, target)
            in 19..42 -> rootTask = CastSpellOnNPC(Magic.CURSE, target)
            in 43..54 ->
                if(Skill.SMITHING.baseLevel < 15)
                    rootTask = CastSpellOnItem(Magic.SUPERHEAT_ITEM, "Tin ore")
                else
                    rootTask = CastSpellOnItem(Magic.SUPERHEAT_ITEM, "Iron ore")
            in 55..66 -> {}
        }
    }

    override fun onStart(vararg arguments: String?) {
        setLoopDelay(100, 220)
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