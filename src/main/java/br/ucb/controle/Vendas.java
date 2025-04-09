package main.java.br.ucb.controle;

import main.java.br.ucb.entidade.Pedido;
import main.java.br.ucb.entidade.StatusPedido;

public class Vendas {
    public static void processarVenda(Pedido pedido) {
        System.out.println("Processando venda: " + pedido);

        if (Financeiro.processarPagamento(pedido)) {
            Expedicao.processarEntrega(pedido);
        }
    }
}
