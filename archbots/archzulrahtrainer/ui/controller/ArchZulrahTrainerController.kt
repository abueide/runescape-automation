package archbots.archzulrahtrainer.ui.controller

import archbots.archzulrahtrainer.ui.model.SkillPaneModel
import archbots.archzulrahtrainer.ui.model.TotalModel
import com.runemate.game.api.script.framework.core.BotPlatform
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TabPane
import javafx.scene.control.TitledPane
import javafx.scene.layout.VBox
import java.net.URL
import java.util.*

class ArchZulrahTrainerController(val platform: BotPlatform) : Initializable, SkillListener {
    @FXML
    var aboutMain: VBox? = null
    @FXML
    var tabpane: TabPane? = null
    @FXML
    var expdisplay: Accordion? = null

    val totalcontroller = TotalController(platform, TotalModel())
    var skillpanecontrollers = ArrayList<SkillController>()

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        aboutMain?.stylesheets?.addAll(javaClass.classLoader.getResource("archbots/archzulrahtrainer/ui/fxml/background.css").toExternalForm())
        val panes = expdisplay?.panes
        if (panes != null)
            panes.add(TitledPane("Total",FXMLLoader().also {
            }.load<Node>(javaClass.classLoader.getResourceAsStream("archbots/archzulrahtrainer/ui/fxml/skillpane.fxml"))))
    }

    override fun onExperienceGained(event: SkillEvent?) {
        val panes = expdisplay?.panes
        if (panes != null && event != null) {
            if(!panes.map { pane -> pane.text }.contains(event.skill.name)) {
                Platform.runLater {
                    panes.add(TitledPane(event.skill.name, FXMLLoader().also {
                        val controller = SkillController(platform, SkillPaneModel(event.skill))
                        skillpanecontrollers.add(controller)
                        it.setController(controller)
                    }.load<Node>(javaClass.classLoader.getResourceAsStream("archbots/archzulrahtrainer/ui/fxml/skillpane.fxml"))))
                }
            }
            Platform.runLater{
                val controller = skillpanecontrollers.filter{ it.model.skill == event.skill }.first()
                controller.gainExp(event.change)
                totalcontroller.gainExp(event.change)
            }

        }
    }
}