package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Encomienda");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("\n[PEDIDO DE ENCOMIENDA]");
        System.out.println("Buscando un repartidor para transportar la encomienda...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Validando peso permitido... OK");
        System.out.println("Validando embalaje de la encomienda... OK");
        System.out.println("Pedido N° " + getIdPedido()
                + " asignado al repartidor " + nombreRepartidor + ".");
    }
}