package model;

public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("\n[PEDIDO DE COMIDA]");
        System.out.println("Buscando un repartidor con mochila térmica...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Verificando mochila térmica... OK");
        System.out.println("Pedido N° " + getIdPedido()
                + " asignado al repartidor " + nombreRepartidor + ".");
    }
}