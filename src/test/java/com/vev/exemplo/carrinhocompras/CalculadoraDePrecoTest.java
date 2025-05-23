package com.vev.exemplo.carrinhocompras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraDePrecoTest {

    CadastroProduto cp = new CadastroProduto(new LeitorDeProdutos("produtos.dat"));
    CalculadoraDePreco calcPr = CalculadoraDePrecoFactory.freteSimplesDolarBuild();


    // Carrinho Vazio
    @Test
    void carrinhoVazioTest() {
        Carrinho carrinho = new Carrinho();
        
        assertEquals(0, calcPr.calculaCustoBasico(carrinho));
        assertEquals(0, calcPr.calculaCustoAdicional(carrinho));
        assertEquals(0, calcPr.calculaCustoFinal(carrinho));
    }

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

    // Carrinho com vários item, produto com várias unidades, 4 a 10 itens e sem preco em dolar
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

    // Preço de entrega com mais de 10 itens
    @Test
    void carrinhoComMaisDeDezItensTest() {
        Carrinho carrinho = new Carrinho();
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(100), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(120), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(135), 5));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(124), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(152), 10));
        carrinho.novoItem(new ItemDeCarrinho(cp.recuperaPorCodigo(105), 1));

        
        assertEquals(109.0, calcPr.calculaCustoBasico(carrinho), 0.001);
        assertEquals(12.5, calcPr.calculaCustoAdicional(carrinho), 0.001);
        assertEquals(121.8, calcPr.calculaCustoFinal(carrinho), 0.001);
    }

}
