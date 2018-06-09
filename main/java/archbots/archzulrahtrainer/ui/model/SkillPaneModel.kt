package archbots.archzulrahtrainer.ui.model

import com.runemate.game.api.hybrid.local.Skill
import com.runemate.game.api.hybrid.local.Skills
import java.util.concurrent.TimeUnit

class SkillPaneModel(val skill: Skill,
                     val goalLevel: Int = skill.baseLevel + 1,
                     var xpPerHour: Int = 0,
                     var xpToLevel: Int = Skills.getExperienceAt(goalLevel) - skill.experience,
                     var timeToLevel: TimeUnit = TimeUnit.HOURS){
    init {
    }
}