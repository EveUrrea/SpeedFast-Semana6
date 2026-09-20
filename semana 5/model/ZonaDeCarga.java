package modelo;

import java.util.LinkedList;
import java.util.List;

public class ZonaDeCarga {

    private final List<Pedido> pedidos;

    public ZonaDeCarga() {
        pedidos = new LinkedList<>();
        System.out.println("[Zona de carga inicializada]");
    }

    // Agrega un pedido de forma segura al recurso compartido
    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println(
                "Pedido #" + pedido.getId()
                        + " agregado. Destino: "
                        + pedido.getDireccionEntrega()
        );
    }

    // Retira un único pedido de forma sincronizada
    public synchronized Pedido retirarPedido() {

        if (pedidos.isEmpty()) {
            return null;
        }

        return pedidos.remove(0);
    }
}
