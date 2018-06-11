package arch.bots.kotlintemplatebot.ui.controller

import com.runemate.game.api.hybrid.util.Resources
import com.runemate.game.api.script.framework.core.BotPlatform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.layout.VBox
import java.net.URL
import java.nio.charset.Charset
import java.util.*

class KotlinTemplateController(val platform: BotPlatform): Initializable{
    @FXML var aboutMain: VBox? = null

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        aboutMain?.stylesheets?.addAll(Resources.getAsString("arch/bots/kotlintemplate/ui/fxml/background.css", Charset.defaultCharset()))
    }
}