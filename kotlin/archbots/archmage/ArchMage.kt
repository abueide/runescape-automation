package archbots.archmage

import archapi.treebot.framework.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import archbots.archmagebot.ui.controller.ArchMageController
import com.runemate.game.api.hybrid.local.Skill
import archbots.archmage.treebot.branches.SpellSelectedValidator
import com.runemate.game.api.osrs.local.hud.interfaces.Magic

class ArchMage : TreeBot(), EmbeddableUI, SkillListener{
    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(ArchMageController(platform))
        }.let {
            SimpleObjectProperty(it.load(javaClass.classLoader.getResourceAsStream("archbots/archmage/ui/fxml/main.fxml")) as Node)
        }
    }
    init{
        setEmbeddableUI(this)
    }


    fun setTask(){
        when(Skill.MAGIC.baseLevel){
            in 1..2 -> rootTask = SpellSelectedValidator(Magic.WIND_STRIKE)
            in 3..10 -> rootTask = SpellSelectedValidator(Magic.CONFUSE)
            in 11..18 -> rootTask = SpellSelectedValidator(Magic.WEAKEN)
            in 19..42 -> rootTask = SpellSelectedValidator(Magic.CURSE)
            in 55..66 -> {}
        }
    }

    override fun onStart(vararg arguments: String?) {
        setTask()
        setLoopDelay(210, 310)
        eventDispatcher.addListener(this)
        enableTaskDebugger()
    }

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) { }

    override fun onLevelUp(event: SkillEvent?) {
        if(event != null && event.skill == Skill.MAGIC){
            setTask()
        }
    }

}