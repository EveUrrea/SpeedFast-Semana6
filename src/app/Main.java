package app;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        PedidoComida comida = new PedidoComida(
                "001",
                "Av. Italia 456",
                4
        );

        PedidoEncomienda encomienda = new PedidoEncomienda(
                "002",
                "Av. Independencia 123",
                6
        );

        PedidoExpress express = new PedidoExpress(
                "003",
                "Av. Apoquindo 1500",
                7
        );

        System.out.println("=== PEDIDOS SPEEDFAST ===");
        System.out.println();

        comida.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + comida.calcularTiempoEntrega() + " minutos");
        System.out.println();

        encomienda.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + encomienda.calcularTiempoEntrega() + " minutos");
        System.out.println();

        express.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + express.calcularTiempoEntrega() + " minutos");
    }
}