open class Item(val codigo: Int, val nome: String, val preco: Double, var quantidade: Int = 0){
    constructor(item: Item) : this(item.codigo, item.nome, item.preco, item.quantidade)

}
class Lanche(codigo: Int, nome: String, preco: Double) : Item(codigo, nome, preco)
class Bebida(codigo: Int, nome: String, preco: Double) : Item(codigo, nome, preco)
