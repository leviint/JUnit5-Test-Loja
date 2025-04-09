package main.java.br.ucb.controle;

import main.java.br.ucb.entidade.Pedido;
import main.java.br.ucb.entidade.StatusPedido;

public class Expedicao {
    public static void processarEntrega(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(StatusPedido.EM_SEPARACAO);
            System.out.println("Separando mercadorias...");
            pedido.setStatus(StatusPedido.FINALIZADO);
            System.out.println("Pedido entregue com sucesso!");
        }
    }
}
