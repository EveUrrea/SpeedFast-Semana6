package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== SISTEMA SPEEDFAST ==========");

        // Objetos de las subclases guardados en referencias de tipo Pedido
        Pedido pedidoComida =
                new PedidoComida(101, "Avenida Providencia 123");

        Pedido pedidoEncomienda =
                new PedidoEncomienda(102, "Calle Los Alerces 456");

        Pedido pedidoExpress =
                new PedidoExpress(103, "Avenida Las Condes 789");

        // Arreglo que permite demostrar el polimorfismo
        Pedido[] pedidos = {
                pedidoComida,
                pedidoEncomienda,
                pedidoExpress
        };

        String[] repartidores = {
                "Juan Pérez",
                "Camila Soto",
                "Luis Díaz"
        };

        // Ejecución de los métodos sobrescritos y sobrecargados
        for (int i = 0; i < pedidos.length; i++) {
            pedidos[i].asignarRepartidor();
            pedidos[i].asignarRepartidor(repartidores[i]);
        }

        System.out.println("\n=======================================");
        System.out.println("Asignación de pedidos finalizada.");
    }
}
