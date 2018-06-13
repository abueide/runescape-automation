package arch.api

import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition

data class ItemOrder(val name: String, val stacks: Boolean = false, val withdrawQuantity: Int = if(stacks) 0 else 1, val minimumQuantity: Int = 1){
    val definition = ItemDefinition.loadAll { it.name == name && it.stacks() == stacks }.first()
}