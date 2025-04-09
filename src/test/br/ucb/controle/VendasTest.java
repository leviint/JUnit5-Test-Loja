package test.br.ucb.controle;

import main.java.br.ucb.entidade.Cliente;
import main.java.br.ucb.entidade.Pedido;
import main.java.br.ucb.entidade.Produto;
import main.java.br.ucb.externo.BancoDeDados;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendasTest {

    @BeforeAll
    static void antes() {
        Cliente c = new Cliente("12345678901", "Allefy");
        BancoDeDados.addCliente(c);
        Produto p1 = new Produto("iPhone 16 Pro Max", 8000);
        Produto p2 = new Produto("Kinder Ovo", 16);
        BancoDeDados.addProduto(p1);
        BancoDeDados.addProduto(p2);
    }

    @Test
    void venda() {
        Cliente cliente = BancoDeDados.getCliente("12345678901");
        Pedido pedido = new Pedido(cliente);
        Produto iphone = BancoDeDados.getProduto("iPhone 16 Pro Max");
        pedido.adicionarProduto(iphone);
        float valorTotaldoPedido = iphone.getPreco();
        for (int i = 0; i < 7; i++) {
            Produto kinder = BancoDeDados.getProduto("Kinder Ovo");
            pedido.adicionarProduto(kinder);
            valorTotaldoPedido += kinder.getPreco();
        }

        assertEquals(valorTotaldoPedido, pedido.calcularValorTotal());
    }

    @AfterAll
    static void depois(){
        // Limpa o banco de dados
    }
}