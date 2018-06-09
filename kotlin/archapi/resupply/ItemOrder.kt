package archapi.resupply

class ItemOrder(val name: String, val minimumQuantity: Int){
    constructor(name: String): this(name, 1)

}
