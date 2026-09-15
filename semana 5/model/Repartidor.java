package model;

public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            // Retira un pedido de forma segura desde la zona de carga
            Pedido pedido = zonaDeCarga.retirarPedido();

            // Si no quedan pedidos, el repartidor termina su trabajo
            if (pedido == null) {
                System.out.println(
                        "[Repartidor - " + nombre + "] No quedan pedidos por entregar."
                );
                break;
            }

            // El pedido pasa a estar en reparto
            pedido.setEstado(EstadoPedido.EN_REPARTO);

            System.out.println(
                    "[Repartidor - " + nombre + "] Retirando pedido #"
                            + pedido.getId() + "..."
            );

            System.out.println(
                    "[Repartidor - " + nombre + "] Estado: "
                            + pedido.getEstado()
            );

            System.out.println(
                    "[Repartidor - " + nombre + "] Entregando pedido #"
                            + pedido.getId() + "..."
            );

            try {
                // Simula el tiempo necesario para realizar la entrega
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(
                        "[Repartidor - " + nombre + "] Entrega interrumpida."
                );
                return;
            }

            // Finaliza la entrega
            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println(
                    "[Repartidor - " + nombre + "] Pedido #"
                            + pedido.getId() + " - Estado: "
                            + pedido.getEstado()
            );
        }
    }
}