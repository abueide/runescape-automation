package arch.bots.archzulrahtrainer.ui.controller

import arch.bots.archzulrahtrainer.ui.model.TotalModel
import com.runemate.game.api.script.framework.core.BotPlatform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import java.net.URL
import java.util.*

class TotalController(val botPlatform: BotPlatform, val model: TotalModel): Initializable{
    @FXML var levelsgained: Label? = null
    @FXML var xpgained: Label? = null
    @FXML var xphr: Label? = null
    @FXML var xptolevel: Label? = null
    @FXML var timetolevel: Label? = null
    @FXML var xptogoal: Label? = null
    @FXML var timetogoal: Label? = null

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        xpgained?.text = model.xpgained.toString()
    }

    fun gainExp(amount: Int){
        model.xpgained += amount
        xpgained?.text = model.xpgained.toString()
    }
}