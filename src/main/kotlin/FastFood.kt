import kotlin.NumberFormatException

class FastFood {
    private val lanches = listOf(Lanche(1, "X-Burger", 10.00), Lanche(2, "X-Salada", 12.00))
    private val bebidas = listOf(Bebida(1, "Refrigerante", 8.00), Bebida(2, "Suco", 6.00))

    private val carrinho = mutableListOf<Item>()
    private var valorTotal: Double = 0.00

    fun iniciar() {
        println("\nBem-Vindo!\n")
        while (true) {
            println("Selecione o que deseja comprar:")
            println("1. Lanche")
            println("2. Bebida")
            println("3. Finalizar Compra")

            when (lerInts()) {
                1 -> {
                    selecionarLanche()
                    break
                }

                2 -> {
                    selecionarBebida()
                    break
                }

                3 -> finalizarPedido()

                else -> println("Opção inválida, tente novamente")
            }
        }

        mostrarCarrinho()
        exibirOpcoesCarrinho()
    }

    private fun lerInts(): Int {
        var numero: Int
        while (true) {
            try {
                numero = readln().toInt()
            } catch (excecao: NumberFormatException) {
                println("Formato inválido, para escolher o item, você deve informar o número dele.")
                continue
            }
            return numero
        }
    }

    private fun finalizarPedido() {

        mostrarCarrinho()
        while (true) {
            println("Escolha a forma de pagamento:")
            println("1. Cartão de Crédito")
            println("2. Cartão de Débito")
            println("3. Vale Refeição")
            println("4. Dinheiro")
            println("5. Desistir da compra")
            when (lerInts()) {
                1, 2, 3 -> println("Compra finalizada com sucesso! Boa refeição.")
                4 -> pagarEmDinheiro()
                5 -> break
                else -> {
                    println("Opção inválida, tente novamente")
                    continue
                }

            }
            println("Retire o seu pedido no balcão!")
            break
        }

        println("Próximo cliente em: ")
        for (i in 5 downTo 1) {
            println(i)
            Thread.sleep(1000)

        }
        carrinho.clear()
        valorTotal = 0.0
        iniciar()
    }

    private fun pagarEmDinheiro() {
        while (true) {
            var dinheiro: Double
            try {
                println("Digite o valor em dinheiro:")
                dinheiro = readln().toDouble()
            } catch (excecao: NumberFormatException) {
                println("Digite um valor válido!")
                continue
            }

            if (dinheiro >= valorTotal) {
                val troco = dinheiro - valorTotal
                println("Compra finalizada com sucesso! Troco: R$%.2f".format(troco))
            } else {
                println("Valor insuficiente. Insira um valor maior ou igual ao total da compra.")
                continue
            }
            break
        }
    }

    private fun editarItem() {
        while (true) {
            println("Digite o código do item que deseja editar:")
            val codigoItem = lerInts()
            val indice = codigoItem - 1


            if (indice in 0 until carrinho.size) {
                val item = carrinho[indice]

                val quantidade = validaQuantidade()

                valorTotal += item.preco * (quantidade - item.quantidade)
                item.quantidade = quantidade
                mostrarCarrinho()
                exibirOpcoesCarrinho()

            } else {
                println("Código inválido, tente novamente")
                continue
            }
            break
        }
    }

    private fun removerItem() {
        while (true) {

            println("Digite o código do item que deseja remover:")
            val codigoItem = lerInts()
            val index = codigoItem - 1

            if (index in 0 until carrinho.size) {
                val item = carrinho.removeAt(index)
                valorTotal -= item.preco * item.quantidade
                mostrarCarrinho()
                exibirOpcoesCarrinho()
            } else {
                println("Código inválido, tente novamente")
                continue
            }
            break
        }
    }

    private fun mostrarCarrinho() {
        carrinho.forEachIndexed { index, item ->
            println(
                "${index + 1}. ${item.nome} \tPreço: R$%.2f \t\tQuantidade: ${item.quantidade} \t\tTotal: R$%.2f".format(
                    item.preco,
                    (item.preco * item.quantidade)
                )
            )
        }
        println("Total da compra: R$%.2f".format(valorTotal))
    }

    private fun exibirOpcoesCarrinho() {

        println("1. Adicionar mais itens")
        println("2. Editar um item")
        println("3. Remover um item")
        println("4. Finalizar o pedido")

        when (readln()) {
            "1" -> iniciar()
            "2" -> editarItem()
            "3" -> removerItem()
            "4" -> finalizarPedido()
            else -> {
                println("Opção inválida, tente novamente")
                exibirOpcoesCarrinho()
            }
        }
    }

    private fun selecionarLanche() {

        while (true) {
            println("Selecione o lanche:")
            lanches.forEach { lanche -> println("${lanche.codigo}. ${lanche.nome}") }

            val opcaoLanche = lerInts()

            val lancheSelecionado = lanches.find { it.codigo == opcaoLanche }

            if (lancheSelecionado != null) {
                adicionarAoCarrinho(lancheSelecionado)
                break
            } else {
                println("Opção inválida, tente novamente")
            }
        }
    }

    private fun selecionarBebida() {
        while (true) {
            println("Selecione a bebida:")
            bebidas.forEach { bebida -> println("${bebida.codigo}. ${bebida.nome}") }
            val opcaoBebida = lerInts()

            val bebidaSelecionada = bebidas.find { it.codigo == opcaoBebida }
            if (bebidaSelecionada != null) {
                adicionarAoCarrinho(bebidaSelecionada)
                break
            } else {
                println("Opção inválida, tente novamente")
            }
        }
    }

    private fun adicionarAoCarrinho(item: Item) {
        val quantidade = validaQuantidade()
        val itemCopiado = Item(item)
        itemCopiado.quantidade = quantidade
        //item.quantidade += quantidade
        carrinho.add(itemCopiado)
        valorTotal += itemCopiado.preco * quantidade
        println("Item adicionado ao carrinho!")
    }

    private fun validaQuantidade(): Int {
        var quantidade: Int

        while (true) {
            println("Digite a quantidade:")
            try {
                quantidade = readln().toInt()
                if (quantidade <= 0) {
                    println("Quantidade inválida!")
                    continue
                }
            } catch (excecao: NumberFormatException) {
                println("Quantidade inválida!")
                continue
            }
            return quantidade
        }
    }

}