package main.java.br.ucb;

import main.java.br.ucb.controle.Vendas;
import main.java.br.ucb.entidade.Cliente;
import main.java.br.ucb.entidade.Pedido;
import main.java.br.ucb.entidade.Produto;
import main.java.br.ucb.entidade.StatusPedido;
import main.java.br.ucb.externo.BancoDeDados;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("12345678900", "João da Silva");
        Produto produto1 = new Produto("Notebook", 3500.00f);
        Produto produto2 = new Produto("Mouse", 150.00f);


        BancoDeDados.addCliente(cliente);
        BancoDeDados.addProduto(produto1);
        BancoDeDados.addProduto(produto2);


        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);


        Vendas.processarVenda(pedido);


        System.out.println("Pedido processado.");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Valor total: R$ " + pedido.calcularValorTotal());
        System.out.println("Status final do pedido: " + pedido.getStatus());


        if (pedido.getStatus() == StatusPedido.CANCELADO) {
            System.out.println("O pedido foi cancelado por inadimplência.");
        } else {
            System.out.println("O pedido foi finalizado com sucesso.");
        }
    }
}
