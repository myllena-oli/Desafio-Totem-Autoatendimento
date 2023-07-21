# Desafio - Totem de auto-atendimento

Este é um simples sistema de pedido de comida rápida desenvolvido em Kotlin, baseado nos conceitos de Programação Orientada a Objetos (POO). O programa permite ao usuário selecionar entre lanches e bebidas disponíveis, adicionar itens ao carrinho, 
editar a quantidade de itens no carrinho, remover itens do carrinho, selecionar uma forma de pagamento e finalizar o pedido.

## Detalhes

- O programa permite que você adicione diferentes quantidades de cada item ao carrinho sem afetar os outros itens na lista.
- O valor total da compra é atualizado de acordo com as adições e edições realizadas.
- Caso deseje finalizar a compra com pagamento em dinheiro, insira o valor em dinheiro quando solicitado. O programa calculará o troco, se houver.
- Ao finalizar a compra, o programa exibirá uma contagem regressiva antes de iniciar um novo pedido.

## Classes e Conceitos de POO

### Classe `Item`

- A classe `Item` é a classe base para representar itens no FastFood.
- Possui as seguintes propriedades:
  - `codigo`: Inteiro que representa o código do item.
  - `nome`: String que representa o nome do item.
  - `preco`: Double que representa o preço do item.
  - `quantidade`: Inteiro que representa a quantidade do item no carrinho.
- Conceitos de POO aplicados:
  - Encapsulamento: As propriedades são definidas como privadas e acessadas por meio de métodos públicos (getters e setters) para proteger os dados.
  - Herança: A classe `Item` é uma classe base para outras classes, como `Lanche` e `Bebida`. As classes derivadas herdam as propriedades e comportamentos da classe base.
  - Construtores: A classe `Item` possui dois construtores, um construtor primário para criar novos itens e um construtor secundário para criar cópias de itens existentes.

### Classes `Lanche` e `Bebida`

- As classes `Lanche` e `Bebida` são classes derivadas da classe `Item`.
- Representam lanches e bebidas específicos disponíveis no FastFood.
- Conceitos de POO aplicados:
  - Herança: Ambas as classes herdam as propriedades e métodos da classe `Item`.
  - Polimorfismo: As classes derivadas podem ser tratadas como objetos da classe base (`Item`) quando necessário.

### Classe `FastFood`

- A classe `FastFood` é responsável por coordenar o funcionamento do sistema de pedido.
- Possui propriedades, como listas de lanches e bebidas disponíveis, um carrinho de compras e um valor total da compra.
- Conceitos de POO aplicados:
  - Encapsulamento: As propriedades são definidas como privadas para limitar o acesso direto a elas e garantir a integridade dos dados.
  - Composição: A classe `FastFood` possui uma lista de itens (lanche e bebida) que são compostos para formar o menu disponível.
  - Métodos públicos: Métodos públicos são usados para iniciar o processo de compra, adicionar itens ao carrinho, finalizar o pedido e outras operações do sistema.

### Tratamento de Exceções

- No método `lerInts()` da classe `FastFood`, é usado o tratamento de exceção `NumberFormatException` para lidar com entradas inválidas do usuário. Caso o usuário digite um valor que não pode ser convertido para `Int`, uma mensagem de erro é exibida, e o programa solicita novamente uma entrada válida.



