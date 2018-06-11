package archbots.archzulrahtrainer.ui.model

import com.runemate.game.api.hybrid.local.Skill
import com.runemate.game.api.hybrid.local.Skills
import java.util.concurrent.TimeUnit

class SkillPaneModel(val skill: Skill,
                     val goalLevel: Int = skill.baseLevel + 1,
                     var xpgained: Long = 0,
                     var xpPerHour: Long = 0,
                     var xpToLevel: Int = Skills.getExperienceAt(goalLevel) - skill.experience
                     ){

    constructor(skill: Skill): this(skill, 0, 0, 0, 0)
}