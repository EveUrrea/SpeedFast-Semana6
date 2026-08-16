package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Compra Express");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("\n[PEDIDO EXPRESS]");
        System.out.println("Buscando el repartidor más cercano...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Comprobando disponibilidad inmediata... OK");
        System.out.println("Repartidor más cercano encontrado.");
        System.out.println("Pedido N° " + getIdPedido()
                + " asignado al repartidor " + nombreRepartidor + ".");
    }
}
