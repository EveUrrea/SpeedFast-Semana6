package app;

import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;
import modelo.Repartidor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida(
                101,
                "Av. Providencia 1200",
                5.5
        );

        Pedido pedido2 = new PedidoExpress(
                102,
                "Av. Apoquindo 3000",
                3.0
        );

        Pedido pedido3 = new PedidoEncomienda(
                103,
                "Gran Avenida 4500",
                7.2
        );

        Pedido pedido4 = new PedidoComida(
                104,
                "Av. Independencia 1800",
                4.5
        );

        Pedido pedido5 = new PedidoExpress(
                105,
                "Av. Las Condes 8500",
                6.0
        );

        Pedido pedido6 = new PedidoEncomienda(
                106,
                "Av. Matta 2100",
                8.0
        );

        List<Pedido> pedidosCamila = Arrays.asList(
                pedido1,
                pedido2
        );

        List<Pedido> pedidosLuis = Arrays.asList(
                pedido3,
                pedido4
        );

        List<Pedido> pedidosSofia = Arrays.asList(
                pedido5,
                pedido6
        );

        Repartidor camila = new Repartidor(
                "Camila",
                pedidosCamila
        );

        Repartidor luis = new Repartidor(
                "Luis",
                pedidosLuis
        );

        Repartidor sofia = new Repartidor(
                "Sofía",
                pedidosSofia
        );

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        System.out.println("=== INICIO DE ENTREGAS SPEEDFAST ===");

        executor.execute(camila);
        executor.execute(luis);
        executor.execute(sofia);

        executor.shutdown();

        try {

            if (!executor.awaitTermination(
                    1,
                    TimeUnit.MINUTES
            )) {

                System.out.println(
                        "Las entregas están tardando demasiado."
                );

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            System.out.println(
                    "La ejecución principal fue interrumpida."
            );

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "=== TODOS LOS REPARTIDORES FINALIZARON ==="
        );
    }
}