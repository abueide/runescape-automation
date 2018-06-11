package arch.bots.kotlintemplate

import arch.api.treebot.TreeBot
import arch.bots.kotlintemplate.ui.controller.KotlinTemplateController
import com.runemate.game.api.client.embeddable.EmbeddableUI
import com.runemate.game.api.hybrid.util.Resources
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node

class KotlinTemplate : TreeBot(), EmbeddableUI, SkillListener {
    private val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(KotlinTemplateController(platform))
        }.let {
            SimpleObjectProperty(it.load(Resources.getAsStream("main.fxml")) as Node)
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

    override fun onExperienceGained(event: SkillEvent?) {}

}