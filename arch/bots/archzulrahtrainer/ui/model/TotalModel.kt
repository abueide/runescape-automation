package arch.bots.archzulrahtrainer.ui.model

import com.runemate.game.api.hybrid.local.Skill
import com.runemate.game.api.hybrid.local.Skills
import java.util.concurrent.TimeUnit

class TotalModel(var xpgained: Int = 0,
                 var xpPerHour: Int = 0){
    constructor(): this(0,0)
}