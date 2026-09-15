package app;

import model.Pedido;
import model.Repartidor;
import model.ZonaDeCarga;

public class Main {

    public static void main(String[] args) {

        // Crear la zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregar pedidos a la zona de carga
        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ñuñoa"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Las Condes"));

        System.out.println("\n--- INICIO DE LAS ENTREGAS ---\n");

        // Crear los tres repartidores
        Repartidor repartidor1 = new Repartidor("Juan", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("Camila", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Pedro", zonaDeCarga);

        // Crear los hilos
        Thread hilo1 = new Thread(repartidor1);
        Thread hilo2 = new Thread(repartidor2);
        Thread hilo3 = new Thread(repartidor3);

        // Iniciar los tres hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            // Esperar a que los tres repartidores terminen
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El proceso principal fue interrumpido.");
        }

        System.out.println("\nTodos los pedidos han sido entregados correctamente");
    }
}
