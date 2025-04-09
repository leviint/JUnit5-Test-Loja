package main.java.br.ucb.externo;

import java.util.Random;

public class Banco {
    public static boolean verificarPagamento() {
        return new Random().nextBoolean(); // true = pago, false = inadimplente
    }
}
