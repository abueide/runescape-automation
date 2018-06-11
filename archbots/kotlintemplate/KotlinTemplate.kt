package archbots.kotlintemplate

import archapi.treebot.TreeBot
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import archbots.kotlintemplatebot.ui.controller.KotlinTemplateController

class KotlinTemplate : TreeBot(), EmbeddableUI, SkillListener{
    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(KotlinTemplateController(platform))
        }.let {
            SimpleObjectProperty(it.load(javaClass.classLoader.getResourceAsStream("main.fxml")) as Node)
        }
    }

    init {
        setEmbeddableUI(this)
        rootTask = TemplateRoot()
    }

    override fun onStart(vararg arguments: String?) {
        super.onStart(*arguments)
        setLoopDelay(100, 190)
        eventDispatcher.addListener(this)
    }

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) { }

}