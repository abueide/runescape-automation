package archbots.archmagebot.ui.controller

import com.runemate.game.api.script.framework.core.BotPlatform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.TabPane
import javafx.scene.layout.VBox
import java.net.URL
import java.util.*

class ArchMageController(val platform: BotPlatform): Initializable{
    @FXML var aboutMain: VBox? = null
    @FXML var tabpane: TabPane? = null

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        aboutMain?.stylesheets?.addAll(javaClass.classLoader.getResource("archbots/archmage/ui/fxml/background.css").toExternalForm())
    }
}