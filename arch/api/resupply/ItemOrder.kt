package arch.api.resupply

class ItemOrder(val name: String, val restockQuantity: Int, val minimumQuantity: Int) {
    constructor(name: String, restockQuantity: Int) : this(name, restockQuantity, 1)
}
