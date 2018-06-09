package archbots.archmage

import archapi.treebot.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import archbots.archmagebot.ui.controller.ArchMageController
import com.runemate.game.api.hybrid.local.Skill

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
        taskDebugger = true
    }



    override fun onStart(vararg arguments: String?) {
        setLoopDelay(100, 220)
        eventDispatcher.addListener(this)
    }

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) { }

    override fun onLevelUp(event: SkillEvent?) {
        if(event != null && event.skill == Skill.MAGIC){
        }
    }

}