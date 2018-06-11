package arch.bots.nullhide

import arch.api.treebot.TreeBot
import arch.bots.nullhide.ui.controller.SettingsController
import com.runemate.game.api.client.embeddable.EmbeddableUI
import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXMLLoader
import javafx.scene.Node


class NullHide : TreeBot(), EmbeddableUI {
    val root = Root()
    val botInterfaceProperty by lazy {
        FXMLLoader().also {
            it.setController(SettingsController(getPlatform()))
        }.let {
            SimpleObjectProperty(it.load() as Node)
        }
    }

    init {
        setEmbeddableUI(this)
        rootTask = root
    }


    override fun botInterfaceProperty() = botInterfaceProperty

    override fun onStart(vararg arguments: String?) = setLoopDelay(100, 190)

}