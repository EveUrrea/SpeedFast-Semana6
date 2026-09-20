package app;

import modelo.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Lista para almacenar el historial de pedidos
        ArrayList<Pedido> historial = new ArrayList<>();

        System.out.println("========================================");
        System.out.println("       SISTEMA DE ENTREGAS SPEEDFAST");
        System.out.println("========================================");
        System.out.println();

        // ==================================================
        // PEDIDO DE COMIDA
        // ==================================================
        System.out.println("----- PEDIDO DE COMIDA -----");

        PedidoComida comida =
                new PedidoComida(101, "Av. Providencia 1200", 5.0);

        comida.mostrarResumen();

        System.out.println("\nAsignación automática:");
        comida.asignarRepartidor();

        System.out.println(
                "Tiempo estimado: "
                        + comida.calcularTiempoEntrega()
                        + " minutos"
        );

        comida.despachar();

        historial.add(comida);

        System.out.println();


        // ==================================================
        // PEDIDO DE ENCOMIENDA
        // ==================================================
        System.out.println("----- PEDIDO DE ENCOMIENDA -----");

        PedidoEncomienda encomienda =
                new PedidoEncomienda(102, "Av. Santa Rosa 567", 7.0);

        encomienda.mostrarResumen();

        System.out.println("\nAsignación manual:");

        // Método sobrecargado heredado desde Pedido
        encomienda.asignarRepartidor("Daniela Tapia");

        System.out.println(
                "Tiempo estimado: "
                        + encomienda.calcularTiempoEntrega()
                        + " minutos"
        );

        encomienda.despachar();

        historial.add(encomienda);

        System.out.println();


        // ==================================================
        // PEDIDO EXPRESS
        // ==================================================
        System.out.println("----- PEDIDO EXPRESS -----");

        PedidoExpress express =
                new PedidoExpress(103, "Av. Apoquindo 1500", 4.0);

        express.mostrarResumen();

        System.out.println("\nAsignación automática:");
        express.asignarRepartidor();

        System.out.println(
                "Tiempo estimado: "
                        + express.calcularTiempoEntrega()
                        + " minutos"
        );

        System.out.println("\nCancelando Pedido Express #103...");
        express.cancelar();

        historial.add(express);

        System.out.println();


        // ==================================================
        // DEMOSTRACIÓN DE POLIMORFISMO
        // ==================================================
        System.out.println("----- DEMOSTRACIÓN DE POLIMORFISMO -----");

        Pedido[] pedidos = {
                comida,
                encomienda,
                express
        };

        for (Pedido pedido : pedidos) {
            System.out.println(
                    "Pedido #" + pedido.getId()
                            + " - Tiempo estimado: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );
        }

        System.out.println();


        // ==================================================
        // HISTORIAL
        // ==================================================
        System.out.println("----- HISTORIAL DE PEDIDOS -----");

        for (Pedido pedido : historial) {

            if (pedido instanceof Rastreable) {
                Rastreable rastreable = (Rastreable) pedido;
                rastreable.verHistorial();
            }
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("          FIN DE LA SIMULACIÓN");
        System.out.println("========================================");
    }
}