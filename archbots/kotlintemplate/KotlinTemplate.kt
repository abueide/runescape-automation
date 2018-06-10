package archbots.kotlintemplate

import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import com.runemate.game.api.script.framework.tree.TreeBot
import com.runemate.game.api.script.framework.tree.TreeTask
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import archbots.kotlintemplatebot.ui.controller.KotlinTemplateController

class KotlinTemplate : TreeBot(), EmbeddableUI, SkillListener{
    private val root = TemplateRoot()
    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(KotlinTemplateController(platform))
        }.let {
            SimpleObjectProperty(it.load(javaClass.classLoader.getResourceAsStream("main.fxml")) as Node)
        }
    }

    init {
        setEmbeddableUI(this)
    }

    override fun onStart(vararg arguments: String?) {
        setLoopDelay(100, 190)
        eventDispatcher.addListener(this)
    }

    override fun createRootTask(): TreeTask = root

    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onExperienceGained(event: SkillEvent?) { }

}