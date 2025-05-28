# Exercício Verival 

## Descrição

Este repositório contém um conjunto de casos de teste para a classe `CalculadoraDePreco`. O objetivo é validar o correto funcionamento dos métodos responsáveis pelo cálculo de preços em diferentes cenários.

## Estrutura dos Testes

- Testes de cálculo com valores padrão
- Testes com descontos aplicados
- Testes com taxas adicionais
- Testes de tratamento de valores inválidos

## Como Executar

1. Clone o repositório.
2. Execute os testes utilizando 

## Estratégia de Testes

O cálculo do custo básico irá necessitar de um carrinho qualquer para testar a soma dos preços unitários dos produtos multiplicados pela quantidade.

Já o cálculo dos custos adicionais pode ser feito criando-se stubs para os custos adicionais que retornem valores conhecidos. Pode-se usar o mesmo carrinho que para o teste do custo básico porque este não irá influenciar nos testes e irá retornar um custo básico conhecido.

Finalmente, precisamos testar a calculadora de preços usando um carrinho “real” e custos adicionais “reais” de maneira a verificar se funcionam todos em conjunto.

Para isso, foram criados 4 novos métodos de teste:

### carrinhoVazioTest:

```java
// Carrinho Vazio
    @Test
    void carrinhoVazioTest() {
        Carrinho carrinho = new Carrinho();
        
        assertEquals(0, calcPr.calculaCustoBasico(carrinho));
        assertEquals(0, calcPr.calculaCustoAdicional(carrinho));
        assertEquals(0, calcPr.calculaCustoFinal(carrinho));
    }
```

### carrinhoComUmItemTest

```java
// Carrinho com 1 item, produto com uma unidade, 1 a 3 itens e com preco em dolar
    // Problema de arredondamento, precisa de delta para validar erro de aproximacao
    @Test
    void carrinhoComUmItemTest() {
        Carrinho carrinho = new Carrinho();
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(105), 1));
        
        assertEquals(1.2, calcPr.calculaCustoBasico(carrinho), 0.001);
        assertEquals(12.5, calcPr.calculaCustoAdicional(carrinho), 0.001);
        assertEquals(13.7, calcPr.calculaCustoFinal(carrinho), 0.001);
    }
```

### carrinhoComVariosItensTest()

```java
// Carrinho com vários item, produto com várias unidades, 4 a 10 itens e sem preço em dólar
    @Test
    void carrinhoComVariosItensTest() {
        Carrinho carrinho = new Carrinho();
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(100), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(120), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(135), 5));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(124), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(152), 10));
        
        assertEquals(107.8, calcPr.calculaCustoBasico(carrinho), 0.001);
        assertEquals(12.5, calcPr.calculaCustoAdicional(carrinho), 0.001);
        assertEquals(120.3, calcPr.calculaCustoFinal(carrinho), 0.001);
    }
```

### carrinhoComMaisDeDezItensTest

```java
// Preço de entrega com mais de 10 itens
    @Test
    void carrinhoComMaisDeDezItensTest() {
        Carrinho carrinho = new Carrinho();
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(100), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(120), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(135), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(124), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(152), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(105), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(160), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(165), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(170), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(175), 1));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(180), 1));
        
        assertEquals(30.18, calcPr.calculaCustoBasico(carrinho), 0.001);
        assertEquals(27.5, calcPr.calculaCustoAdicional(carrinho), 0.001);
        assertEquals(57.68, calcPr.calculaCustoFinal(carrinho), 0.001);
    }
```

**Veja mais nas issues do projeto!**


## Contribuição 

Sinta-se à vontade para sugerir novos casos de teste ou melhorias.

