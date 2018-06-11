package arch.bots.archzulrahtrainer.ui.controller

import arch.bots.archzulrahtrainer.ui.model.SkillPaneModel
import arch.bots.archzulrahtrainer.ui.model.TotalModel
import com.runemate.game.api.hybrid.util.Resources
import com.runemate.game.api.script.framework.core.BotPlatform
import com.runemate.game.api.script.framework.listeners.SkillListener
import com.runemate.game.api.script.framework.listeners.events.SkillEvent
import io.socket.utf8.UTF8
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
import java.nio.charset.Charset
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
        aboutMain?.stylesheets?.addAll(Resources.getAsString("arch/bots/archzulrahtrainer/ui/fxml/background.css", Charset.defaultCharset()))
        val panes = expdisplay?.panes
        if (panes != null)
            panes.add(TitledPane("Total",FXMLLoader().also {
            }.load<Node>(Resources.getAsStream("arch/bots/archzulrahtrainer/ui/fxml/skillpane.fxml"))))
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
                    }.load<Node>(Resources.getAsStream("arch/bots/archzulrahtrainer/ui/fxml/skillpane.fxml"))))
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