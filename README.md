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




## Contribuição

Sinta-se à vontade para sugerir novos casos de teste ou melhorias.

