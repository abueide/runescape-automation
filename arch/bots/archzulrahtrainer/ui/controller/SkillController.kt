package arch.bots.archzulrahtrainer.ui.controller

import arch.bots.archzulrahtrainer.ArchZulrahTrainer
import arch.bots.archzulrahtrainer.ui.model.SkillPaneModel
import com.runemate.game.api.hybrid.Environment
import com.runemate.game.api.script.framework.core.BotPlatform
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import java.net.URL
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.roundToLong

class SkillController(val botPlatform: BotPlatform, val model: SkillPaneModel) : Initializable {
    @FXML
    var levelsgained: Label? = null
    @FXML
    var xpgained: Label? = null
    @FXML
    var xphr: Label? = null
    @FXML
    var xptolevel: Label? = null
    @FXML
    var timetolevel: Label? = null
    @FXML
    var xptogoal: Label? = null
    @FXML
    var timetogoal: Label? = null

    val titlePane = TitledPane()

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        xpgained?.text = model.xpgained.toString()
    }

    fun gainExp(amount: Int) {
        model.xpgained += amount
        botPlatform.invokeAndWait {
            val time = (Environment.getBot() as ArchZulrahTrainer).stopWatch.getRuntime(TimeUnit.SECONDS)
            model.xpPerHour = (model.xpgained / time.toDouble() * 3600).roundToLong()
        }
        Platform.runLater {
            xpgained?.text = model.xpgained.toString()
            xphr?.text = model.xpPerHour.toString()
        }
    }
}

