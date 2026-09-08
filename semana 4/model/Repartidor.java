package model;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (Pedido pedido : pedidosAsignados) {
            try {
                pedido.asignarRepartidor(nombre);

                System.out.println(
                        "[Repartidor: " + nombre + "] Entregando "
                                + pedido.getClass().getSimpleName()
                                + " #" + pedido.getIdPedido() + "..."
                );

                int tiempoEspera = 1000 + random.nextInt(2001);
                Thread.sleep(tiempoEspera);

                pedido.setEstado("Entregado");

                System.out.println(
                        "[Repartidor: " + nombre + "] Pedido #"
                                + pedido.getIdPedido() + " entregado."
                );

            } catch (InterruptedException e) {
                System.out.println(
                        "[Repartidor: " + nombre + "] La entrega fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
                "[Repartidor: " + nombre + "] Finalizó todas sus entregas."
        );
    }
}
