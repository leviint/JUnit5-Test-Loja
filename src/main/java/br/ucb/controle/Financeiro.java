package main.java.br.ucb.controle;

import main.java.br.ucb.entidade.Pedido;
import main.java.br.ucb.entidade.StatusPedido;
import main.java.br.ucb.externo.Banco;

public class Financeiro {
    public static boolean processarPagamento(Pedido pedido) {
        boolean pago = Banco.verificarPagamento();
        if (!pago) {
            pedido.getCliente().mudarInadimplencia();
            pedido.setStatus(StatusPedido.CANCELADO);
            System.out.println("Cliente inadimplente. Pedido cancelado.");
        } else {
            pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
            System.out.println("Pagamento aprovado. Aguardando envio.");
        }
        return pago;
    }
}
